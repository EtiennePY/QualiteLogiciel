package lecteur;

import java.util.logging.Logger;

import carte.Carte;
import carte.CarteAbonnement;
import carte.CarteWithout;
import client.ClientAbonne;
import systemeInformatique.SystemeInformatique;

public class LecteurCarteAbonnement implements ILecteurCarteAbonnement {

  public LecteurCarteAbonnement() {
    this.carteClient = CarteWithout.instance();
  }

  private Carte carteClient;
  /** The logger. */

  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

  public void restitutionCarte(boolean retour) { 
    if(retour) {
      LOG.info("Un message s'affiche : \"OK\" sur l'écran du lecteur et la carte sort" );
    } else {
      LOG.info("Un message s'affiche : \"Carte erronée\" sur l'écran du lecteur et la carte sort" );
    }
  }
  
  
public void demandeInsertionCarte(boolean detecte) {
    if (detecte) {
      LOG.info("L'écran du lecteur de carte d'abonnement affiche \"Insérez votre carte d'abonnement\"");
    }
  }
  
  public boolean checkAbonnement(SystemeInformatique sys) {
    this.setCarteClient(this.getCarteClient());
    LOG.info("Le lecteur de carte d'abonnement reçoit la carte d'abonnement.");
    return sys.checkAbonnement(this.getCarteClient(), this);
  }
  
  public Carte getCarteClient() {
    return carteClient;
  }

  public void setCarteClient(Carte carteClient) {
    this.carteClient = carteClient;
  }
}