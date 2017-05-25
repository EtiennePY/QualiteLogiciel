package cartes.impl;

import abonnement.Abonnement;
import cartes.inter.ICarteAbonnement;

// TODO: Auto-generated Javadoc
/**
 * The Class CarteAbonnement.
 */
public class CarteAbonnement extends AbstractCarteWith implements ICarteAbonnement {

  /** The abonnement. */
  protected Abonnement abonnement;

  /**
   * Instantiates a new carte abonnement.
   *
   * @param identifiant the identifiant
   * @param abonnement the abonnement
   */
  public CarteAbonnement(final int identifiant, final Abonnement abonnement) {
    super(identifiant);
    this.abonnement = abonnement;
  }


  /**
   * Gets the abonnement.
   *
   * @return the abonnement
   */
  public Abonnement getAbonnement() {
    return abonnement;
  }


  /**
   * Sets the abonnement.
   *
   * @param abonnement the new abonnement
   */
  public void setAbonnement(final Abonnement abonnement) {
    this.abonnement = abonnement;
  }
}
