/*
 * 
 */

package clients.impl;

import java.util.logging.Logger;

import cartes.impl.CarteAbonnement;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import clients.inter.IClientAbonne;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import vehicule.inter.IVehicule;
// TODO: Auto-generated Javadoc
/**
 * The Class ClientAbonne.
 */

public class ClientAbonne extends AbstractClient implements IClientAbonne {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
  /** The carte abonnement. */
  protected IAbstractCarte carteAbonnement;  
  /**
  * Instantiates a new client abonne.
  *
  * @param vehicules the vehicules
  * @param carteAbonnement the carte abonnement
  */

  public ClientAbonne(final IVehicule vehicule, final IAbstractCarte carteAbonnement) {
    super();
    super.getVehicules().add(vehicule);
    this.carteAbonnement = carteAbonnement;
  }
  
  /**
   * Insere carte abonnement.
   *
   * @param lecteurAbo the lecteur
   */
  public void insereCarteAbonnement(final ILecteurCarteAbonnement lecteurAbo) {
    LOG.info("Le client abonné a inséré sa carte d'abonnement.");
    final IAbstractCarte carte = this.getCarteAbonnement();
    lecteurAbo.setCarteClient(carte);
    this.setCarteAbonnement(CarteWithout.instance());
  }
  
  /**
   * Recupere carte abonnement.
   *
   * @param lecteur the lecteur
   */
  public void recupereCarteAbonnement(final ILecteurCarteAbonnement lecteur) {
    LOG.info("Le client abonné récupère sa carte d'abonnement.");
    final CarteAbonnement carte = (CarteAbonnement) lecteur.getCarteClient();
    this.setCarteAbonnement(carte);
    lecteur.setCarteClient(CarteWithout.instance());
  }
  

  /**
   * Gets the carte abonnement.
   *
   * @return the carte abonnement
   */
  public IAbstractCarte getCarteAbonnement() {
    return carteAbonnement;
  }

  /**
   * Sets the carte abonnement.
   *
   * @param carteAbonnement the new carte abonnement
   */
  public void setCarteAbonnement(final IAbstractCarte carteAbonnement) {
    this.carteAbonnement = carteAbonnement;
  }

@Override
public boolean isAbonne() {
	// TODO Auto-generated method stub
	return true;
}
}
