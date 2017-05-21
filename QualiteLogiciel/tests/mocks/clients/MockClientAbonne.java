package mocks.clients;

import java.util.logging.Logger;

import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import cartes.inter.ICarteAbonnement;
import clients.inter.IClientAbonne;
import erreurs.CarteAbonnementErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import vehicule.inter.IVehicule;
// TODO: Auto-generated Javadoc
/**
 * The Class ClientAbonne.
 */

public class MockClientAbonne extends MockAbstractClient implements IClientAbonne {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(MockClientAbonne.class.getName());
  /** The carte abonnement. */
  protected IAbstractCarte carteAbonnement;  
  
  /**
   * Instantiates a new client abonne.
   *
   * @param vehicule the vehicule
   * @param carteAbonnement the carte abonnement
   */

  public MockClientAbonne(final IVehicule vehicule, final IAbstractCarte carteAbonnement) {
    super();
    super.getVehicules().add(vehicule);
    this.carteAbonnement = carteAbonnement;
  }
  
  /**
   * Insere carte abonnement.
   *
   * @param lecteurAbo the lecteur
   * @throws CarteAbonnementErreur the carte abonnement erreur
   */
  public void insereCarteAbonnement(final ILecteurCarteAbonnement lecteurAbo) throws CarteAbonnementErreur {
	  if(this.carteAbonnement.isWith()) {
    LOG.info("Le client abonné a inséré sa carte d'abonnement.");
    final IAbstractCarte carte = this.getCarteAbonnement();
    lecteurAbo.setCarteClient(carte);
    this.setCarteAbonnement(CarteWithout.instance());
	  }
	  else {
		  throw new CarteAbonnementErreur("Le client n'a pas de carte d'abonnement.");
	  }
  }
  
  /**
   * Recupere carte abonnement.
   *
   * @param lecteur the lecteur
   */
  public void recupereCarteAbonnement(final ILecteurCarteAbonnement lecteur) {
    LOG.info("Le client abonné récupère sa carte d'abonnement.");
    final ICarteAbonnement carte = (ICarteAbonnement) lecteur.getCarteClient();
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

  /**
  * Checks if is abonne.
  *
  * @return true, if is abonne
  */
  public boolean isAbonne() {
	  return true;
  }
}
