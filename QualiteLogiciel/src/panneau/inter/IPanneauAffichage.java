package panneau.inter;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPanneauAffichage.
 */
public interface IPanneauAffichage {
  
  /**
   * Gets the sortis.
   *
   * @return the sortis
   */
  int getSortis();
  
  /**
   * Sets the sortis.
   *
   * @param sortis the new sortis
   */
  void setSortis(int sortis);
  
  /**
   * Gets the nombre places libres.
   *
   * @return the nombre places libres
   */
  int getNombrePlacesLibres();
  
  /**
   * Gets the entres.
   *
   * @return the entres
   */
  int getEntres();
  
  /**
   * Sets the entres.
   *
   * @param entres the new entres
   */
  void setEntres(int entres);
  
  /**
   * Adds the.
   */
  void add();
  
  /**
   * Minus.
   */
  void minus();
  
  /**
   * Gets the placestotales.
   *
   * @return the placestotales
   */
  int getPlacesTotales();

}
