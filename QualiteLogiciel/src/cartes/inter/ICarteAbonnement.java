package cartes.inter;

import abonnement.Abonnement;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICarteAbonnement.
 */
public interface ICarteAbonnement extends IAbstractCarte {
  
  /**
   * Gets the abonnement.
   *
   * @return the abonnement
   */
  Abonnement getAbonnement();
  
  /**
   * Sets the abonnement.
   *
   * @param abonnement the new abonnement
   */
  void setAbonnement(final Abonnement abonnement);
}
