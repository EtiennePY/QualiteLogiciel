package barriere.inter;

import erreurs.BarriereErreur;

/*
 * 
 */

// TODO: Auto-generated Javadoc
/**
 * The Interface IBarriereSortie.
 */
public interface IBarriereSortie {

  /**
   * Checks if is ouverte.
   *
   * @return true, if is ouverte
   */
  boolean isOuverte();
  
  /**
   * Sets the ouverte.
   *
   * @param ouverte the new ouverte
   */
  void setOuverte(final boolean ouverte);
  
  /**
   * Ouvrir.
   * @throws BarriereErreur
   *  
   */
  void ouvrir() throws BarriereErreur;
  
  /**
   * Fermer.
   * @throws BarriereErreur 
   * 
   */
  void fermer() throws BarriereErreur;

}
