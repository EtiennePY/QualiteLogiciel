/*
 * 
 */

package clients.impl;

import java.util.List;
import java.util.logging.Logger;

import cartes.impl.AbstractCarte;
import cartes.impl.CarteAbonnement;
import cartes.impl.CarteWithout;
import clients.inter.ICLientAbonne;
import lecteurCarteAbonnement.inter.ILecteurCarteAbonnement;
import vehicule.inter.IVehicule;
// TODO: Auto-generated Javadoc
/**
 * The Class ClientAbonne.
 */

public class ClientAbonne extends AbstractClient implements ICLientAbonne {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
  /** The carte abonnement. */
  protected AbstractCarte carteAbonnement;  
  /**
  * Instantiates a new client abonne.
  *
  * @param vehicules the vehicules
  * @param carteAbonnement the carte abonnement
  */

  public ClientAbonne(final List<IVehicule> vehicules, final AbstractCarte carteAbonnement) {
    super();
    super.vehicules = vehicules;
    this.carteAbonnement = carteAbonnement;
  }
  
  /**
   * Insere carte abonnement.
   *
   * @param lecteurAbo the lecteur
   */
  public void insereCarteAbonnement(final ILecteurCarteAbonnement lecteurAbo) {
    LOG.info("Le client abonné a inséré sa carte d'abonnement.");
    lecteurAbo.setCarteClient(this.getCarteAbonnement());
    this.setCarteAbonnement(CarteWithout.instance());
  }
  
  /**
   * Recupere carte abonnement.
   *
   * @param lecteur the lecteur
   */
  public void recupereCarteAbonnement(final ILecteurCarteAbonnement lecteur) {
    LOG.info("Le client abonné récupère sa carte d'abonnement.");
    CarteAbonnement carte = (CarteAbonnement) lecteur.getCarteClient();
    this.setCarteAbonnement(carte);
    lecteur.setCarteClient(CarteWithout.instance());
  }
  

  /**
   * Gets the carte abonnement.
   *
   * @return the carte abonnement
   */
  public AbstractCarte getCarteAbonnement() {
    return carteAbonnement;
  }

  /**
   * Sets the carte abonnement.
   *
   * @param carteAbonnement the new carte abonnement
   */
  public void setCarteAbonnement(final AbstractCarte carteAbonnement) {
    this.carteAbonnement = carteAbonnement;
  }
}
