package barriere;

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
   */
  void ouvrir();
  
  /**
   * Fermer.
   */
  void fermer();

}
