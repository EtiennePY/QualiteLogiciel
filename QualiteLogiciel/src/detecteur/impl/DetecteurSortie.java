package detecteur.impl;

import java.util.logging.Logger;

import barriere.inter.IBarriereSortie;
import clients.impl.AbstractClient;
import clients.impl.ClientAbonne;
import detecteur.inter.IDetecteurSortie;
import lecteurCarteAbonnement.inter.ILecteurCarteAbonnement;
import panneau.inter.IPanneauAffichage;
import systemeInformatique.impl.SystemeInformatique;
import vehicule.inter.IVehicule;

public class DetecteurSortie implements IDetecteurSortie {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

  protected boolean present; 

  public DetecteurSortie() {
    this.present = false;
  }

  public boolean isPresent() {
    return present;
  }

  public void setPresent(final boolean present) {
    this.present = present;
  }

  public void fermeBarriere(final IBarriereSortie barriere) {
    LOG.info("Le detecteur provoque la fermeture de la barrière");
    barriere.fermer();
  }

  public void metAJourPanneauAffichage(final IPanneauAffichage panneau) {
    LOG.info("Le détecteur met à jour le panneau d'affichage");
    panneau.minus();
  }

  public boolean detecteImmatriculationVehicule(final IVehicule vehicule,final SystemeInformatique sys,final ILecteurCarteAbonnement lecteur) {
    if (sys.getIds().containsValue(vehicule.getImmatriculation())) {
      this.setPresent(true);
      LOG.info("Le détecteur a reconnu l'immatriculation : " + vehicule.getImmatriculation() + " du client.");
    } else {
      LOG.info("Le détecteur n'a pas reconnu l'immatriculation : " + vehicule.getImmatriculation() + " du client.");  
    }
    lecteur.demandeInsertionCarte(this.isPresent());
    return this.isPresent();
  }

  public void detecteClient(final AbstractClient client) {
    this.setPresent(true);
    LOG.info("Le détecteur detecte le client " + client.toString());
  }
}