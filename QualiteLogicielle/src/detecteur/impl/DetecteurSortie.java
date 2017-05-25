package detecteur.impl;

import barriere.inter.IBarriereSortie;
import detecteur.inter.IDetecteurSortie;
import erreurs.BarriereErreur;
import java.util.logging.Logger;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import lecteurs.ticket.inter.ILecteurTicket;
import panneau.inter.IPanneauAffichage;
import systemeinfo.inter.ISystemeInformatique;
import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Class DetecteurSortie.
 */
public class DetecteurSortie implements IDetecteurSortie {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(DetecteurSortie.class.getName());

  /** The present. */
  private boolean present; 

  /**
   * Instantiates a new detecteur sortie.
   */
  public DetecteurSortie() {
    this.present = false;
  }

  /**
   * Checks if is present.
   *
   * @return true, if is present
   */
  public boolean isPresent() {
    return present;
  }

  /**
   * Sets the present.
   *
   * @param present the new present
   */
  public void setPresent(final boolean present) {
    this.present = present;
  }

  /**
   * Ferme barriere.
   *
   * @param barriere the barriere
   * @return true, if successful
   * @throws BarriereErreur the barriere erreur
   */
  public boolean fermeBarriere(final IBarriereSortie barriere) throws BarriereErreur {
    LOG.info("Le detecteur provoque la fermeture de la barrière");
    barriere.fermer();
    return barriere.isOuverte();
  }

  /**
   * Met A jour panneau affichage.
   *
   * @param panneau the panneau
   */
  public void metAJourPanneauAffichage(final IPanneauAffichage panneau) {
    LOG.info("Le détecteur met à jour le panneau d'affichage");
    panneau.minus();
  }

  /**
   * Detecte immatriculation vehicule.
   *
   * @param vehicule the vehicule
   * @param sys the sys
   * @param lecteur the lecteur
   * @return true, if successful
   */
  public boolean detecteImmatriculationVehicule(final IVehicule vehicule, 
        final ISystemeInformatique sys, final ILecteurCarteAbonnement lecteur) {
    final boolean resultat = sys.getImmatriculations().containsValue(vehicule.getImmatriculation());
    if (resultat) {
      this.setPresent(true);
      LOG.info("Le détecteur a reconnu l'immatriculation : " 
          + vehicule.getImmatriculation() + " du client.");
      lecteur.demandeInsertionCarte(this.isPresent());

    } else {
      LOG.warning("Le détecteur n'a pas reconnu l'immatriculation : "
          + vehicule.getImmatriculation() + " du client.");  
    }
    return resultat;
  }

  /**
   * Detecte client.
   *
   * @param vehicule the vehicule
   * @param lecteur the lecteur
   * @return true, if successful
   */
  public boolean detecteClient(final IVehicule vehicule, final ILecteurTicket lecteur) {
    this.setPresent(true);
    LOG.info("Le détecteur detecte le client " + vehicule.toString());
    lecteur.demandeInsertionTicket(this.isPresent());
    return this.isPresent();
  }
}