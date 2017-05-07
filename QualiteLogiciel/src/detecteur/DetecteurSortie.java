package detecteur;

import barriere.BarriereSortie;
import client.Client;
import client.ClientAbonne;
import java.util.logging.Logger;
import lecteur.LecteurCarteAbonnement;
import panneau.PanneauAffichage;
import systemeInformatique.SystemeInformatique;
import vehicule.Vehicule;

public class DetecteurSortie {
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

  public void compterVoiture() {
    // TODO Auto-generated method stub
  }

  public void fermeBarriere(final BarriereSortie barriere) {
    LOG.info("Le detecteur provoque la fermeture de la barrière");
    barriere.fermer();
  }

  public void metAJourPanneauAffichage(final PanneauAffichage panneau) {
    LOG.info("Le détecteur met à jour le panneau d'affichage");
    panneau.minus();
  }

  public boolean detecteImmatriculationVehicule(final Vehicule vehicule,final SystemeInformatique sys,final LecteurCarteAbonnement lecteur) {
    if (sys.getIds().containsValue(vehicule.getImmatriculation())) {
      this.setPresent(true);
      LOG.info("Le détecteur a reconnu l'immatriculation : " + vehicule.getImmatriculation() + " du client.");
    } else {
      LOG.info("Le détecteur n'a pas reconnu l'immatriculation : " + vehicule.getImmatriculation() + " du client.");  
    }
    lecteur.demandeInsertionCarte(this.isPresent());
    return this.isPresent();
  }

  public void detecteClient(final Client client) {
    this.setPresent(true);
    LOG.info("Le détecteur detecte le client " + client.toString());
  }
}