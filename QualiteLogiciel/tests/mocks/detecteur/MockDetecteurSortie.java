package mocks.detecteur;

import java.util.logging.Logger;

import barriere.inter.IBarriereSortie;
import detecteur.inter.IDetecteurSortie;
import erreurs.BarriereErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import lecteurs.ticket.inter.ILecteurTicket;
import panneau.inter.IPanneauAffichage;
import systemeinfo.inter.ISystemeInformatique;
import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Class MockDetecteurSortie.
 */
public class MockDetecteurSortie implements IDetecteurSortie {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(MockDetecteurSortie.class.getName());

  /** The present. */
  protected boolean present; 

  /**
   * Instantiates a new mock detecteur sortie.
   */
  public MockDetecteurSortie() {
    this.present = false;
  }

  /* (non-Javadoc)
   * @see detecteur.inter.IDetecteurSortie#isPresent()
   */
  public boolean isPresent() {
    return present;
  }

  /* (non-Javadoc)
   * @see detecteur.inter.IDetecteurSortie#setPresent(boolean)
   */
  public void setPresent(final boolean present) {
    this.present = present;
  }

  /* (non-Javadoc)
   * @see detecteur.inter.IDetecteurSortie#fermeBarriere(barriere.inter.IBarriereSortie)
   */
  public boolean fermeBarriere(final IBarriereSortie barriere) throws BarriereErreur {
    LOG.info("Le detecteur provoque la fermeture de la barrière");
    barriere.fermer();
    return barriere.isOuverte();
  }

  /* (non-Javadoc)
   * @see detecteur.inter.IDetecteurSortie#metAJourPanneauAffichage(panneau.inter.IPanneauAffichage)
   */
  public void metAJourPanneauAffichage(final IPanneauAffichage panneau) {
    LOG.info("Le détecteur met à jour le panneau d'affichage");
    panneau.minus();
  }

  /* (non-Javadoc)
   * @see detecteur.inter.IDetecteurSortie#detecteImmatriculationVehicule(vehicule.inter.IVehicule, systemeinfo.inter.ISystemeInformatique, lecteurs.abonnement.inter.ILecteurCarteAbonnement)
   */
  public boolean detecteImmatriculationVehicule(final IVehicule vehicule,final ISystemeInformatique sys, final ILecteurCarteAbonnement lecteur) {
    if (sys.getImmatriculations().containsValue(vehicule.getImmatriculation())) {
    	this.setPresent(true);
        LOG.info("Le détecteur a reconnu l'immatriculation : " + vehicule.getImmatriculation() + " du client.");
        lecteur.demandeInsertionCarte(this.isPresent());

      } else {
        LOG.warning("Le détecteur n'a pas reconnu l'immatriculation : " + vehicule.getImmatriculation() + " du client.");  
      }
    lecteur.demandeInsertionCarte(this.isPresent());
    return sys.getImmatriculations().containsValue(vehicule.getImmatriculation());
  }

  /* (non-Javadoc)
   * @see detecteur.inter.IDetecteurSortie#detecteClient(vehicule.inter.IVehicule, lecteurs.ticket.inter.ILecteurTicket)
   */
  public boolean detecteClient(final IVehicule vehicule, final ILecteurTicket lecteur) {
    this.setPresent(true);
    LOG.info("Le détecteur detecte le client " + vehicule.toString());
    lecteur.demandeInsertionTicket(this.isPresent());
    return this.isPresent();
  }
}