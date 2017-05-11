/*
 * 
 */
package panneau.impl;

import java.util.logging.Logger;

import clients.impl.ClientAbonne;
import panneau.inter.IPanneauAffichage;

// TODO: Auto-generated Javadoc
/**
 * The Class PanneauAffichage.
 */
public class PanneauAffichage implements IPanneauAffichage {
  
  /** The nbplaces. */
  private final static int PLACESTOTALES = 400;
  
  /** The entres. */
  private int entres;
  
  /** The sortis. */
  private int sortis;
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

  /**
   * Instantiates a new panneau affichage.
   */
  public PanneauAffichage() {
    this.entres = 0;
    this.sortis = 0;
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
   * @return the sortis
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
    return this.getPLACESTOTALES() - this.entres + this.sortis;
  }
  
  /**
   * Gets the placestotales.
   *
   * @return the placestotales
   */
  public int getPLACESTOTALES() {
	return PLACESTOTALES;
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
  public void add(){
    this.setEntres(this.getEntres()+1);
    LOG.info("Le panneau d'affichage incrémente le nombre de places disponibles");
  }
  
  /**
   * Minus.
   */
  public void minus(){
    this.setSortis(this.getSortis()+1);
    LOG.info("Le panneau d'affichage incrémente le nombre de vehicules sortis");
  }
}