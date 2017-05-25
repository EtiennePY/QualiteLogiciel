package panneau.impl;

import java.util.logging.Logger;

import panneau.inter.IPanneauAffichage;

// TODO: Auto-generated Javadoc
/**
 * The Class PanneauAffichage.
 */
public class PanneauAffichage implements IPanneauAffichage {
  
  /** The nbplaces. */
  private static final int PLACESTOTALES = 400;
  
  /** The entres. */
  private int entres;
  
  /** The sortis. */
  private int sortis;
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(PanneauAffichage.class.getName());

  /**
   * Instantiates a new panneau affichage.
   */
  public PanneauAffichage() {
    this.entres = 30;
    this.sortis = 10;
  }
  
  /**
   * Gets the sortis.
   *
   * @return the sortis
   */
  public int getSortis() {
    return sortis;
  }
  
  /**
   * Gets the sortis.
   *
   * @param sortis the new sortis
   */
  public void setSortis(final int sortis) {
    this.sortis = sortis;
  }
  
  /**
   * Sets the sortis.
   *
   * @return the nombre places libres
   */
  public int getNombrePlacesLibres() {
    return getPlacestotales() - this.getEntres() + this.getSortis();
  }
  
 
  /**
 * Sets the entres.
 *
 * @return the entres
 */
  public int getEntres() {
    return entres;
  }
  
  /**
   * Sets the entres.
   *
   * @param entres the new entres
   */
  public void setEntres(final int entres) {
    this.entres = entres;
  }
  
  /**
   * Adds the.
   */
  public void add() {
    this.setEntres(this.getEntres() + 1);
    LOG.info("Le panneau d'affichage incrémente le nombre de places disponibles");
  }
  
  /**
   * Minus.
   */
  public void minus() {
    this.setSortis(this.getSortis() + 1);
    LOG.info("Le panneau d'affichage incrémente le nombre de vehicules sortis");
  }

  /**
   * Gets the placestotales.
   *
   * @return the placestotales
  */
  public static int getPlacestotales() {
    return PLACESTOTALES;
  }
}