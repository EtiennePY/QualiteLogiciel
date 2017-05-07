package lecteur;

import carte.Carte;
import carte.CarteWithout;
import client.ClientAbonne;
import systemeInformatique.SystemeInformatique;
import java.util.logging.Logger;

public class LecteurCarteAbonnement extends Lecteur {

  public LecteurCarteAbonnement() {
    this.carteClient = CarteWithout.instance();
  }

  private Carte carteClient;
  /** The logger. */

  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

  public void restitutionCarte(boolean retour, ClientAbonne client) {
    client.setCarteAbonnement(this.getCarteClient());
    this.setCarteClient(CarteWithout.instance());  
    if(retour) {
      LOG.info("Un message s'affiche : \"OK\" sur l'�cran du lecteur et la carte sort" );
    } else {
      LOG.info("Un message s'affiche : \"Carte erron�e\" sur l'�cran du lecteur et la carte sort" );
    }
  }
  
  public void demandeInsertionCarte(boolean detecte) {
    if (detecte) {
      LOG.info("L'�cran du lecteur de carte d'abonnement affiche \"Ins�rez votre carte d'abonnement\"");
    }
  }
  
  public boolean checkAbonnement(SystemeInformatique sys) {
    this.setCarteClient(this.getCarteClient());
    LOG.info("Le lecteur de carte d'abonnement re�oit la carte d'abonnement.");
    return sys.checkAbonnement(this.getCarteClient(), this);
  }
  
  public Carte getCarteClient() {
    return carteClient;
  }

  public void setCarteClient(Carte carteClient) {
    this.carteClient = carteClient;
  }
}