/*
 * 
 */

package client;

import carte.Carte;
import carte.CarteWithout;
import java.util.List;
import java.util.logging.Logger;
import lecteur.LecteurCarteAbonnement;
import vehicule.Vehicule;
// TODO: Auto-generated Javadoc
/**
 * The Class ClientAbonne.
 */

public class ClientAbonne extends Client {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
  /** The carte abonnement. */
  protected Carte carteAbonnement;  
  /**
  * Instantiates a new client abonne.
  *
  * @param vehicules the vehicules
  * @param carteAbonnement the carte abonnement
  */

  public ClientAbonne(final List<Vehicule> vehicules, final Carte carteAbonnement) {
    super();
    super.vehicules = vehicules;
    this.carteAbonnement = carteAbonnement;
  }
  
  /**
   * Insere carte abonnement.
   *
   * @param lecteur the lecteur
   */
  public void insereCarteAbonnement(final LecteurCarteAbonnement lecteur) {
    LOG.info("Le client abonné a inséré sa carte d'abonnement.");
    lecteur.setCarteClient(this.getCarteAbonnement());
    this.setCarteAbonnement(CarteWithout.instance());
  }
  
  /**
   * Recupere carte abonnement.
   *
   * @param lecteur the lecteur
   */
  public void recupereCarteAbonnement(final LecteurCarteAbonnement lecteur) {
    LOG.info("Le client abonné récupère sa carte d'abonnement.");
    lecteur.setCarteClient(lecteur.getCarteClient());
    lecteur.setCarteClient(CarteWithout.instance());
  }
  

  /**
   * Gets the carte abonnement.
   *
   * @return the carte abonnement
   */
  public Carte getCarteAbonnement() {
    return carteAbonnement;
  }

  /**
   * Sets the carte abonnement.
   *
   * @param carteAbonnement the new carte abonnement
   */
  public void setCarteAbonnement(final Carte carteAbonnement) {
    this.carteAbonnement = carteAbonnement;
  }
}
