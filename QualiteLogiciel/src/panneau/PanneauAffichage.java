package panneau;

import java.util.logging.Logger;
import client.ClientAbonne;

public class PanneauAffichage implements IPanneauAffichage {
  protected final int NBPLACES = 400;
  protected int entres;
  protected int sortis;
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

  public PanneauAffichage() {
    this.entres = 0;
    this.sortis = 0;
  }
  public int getSortis() {
    return sortis;
  }
  public void setSortis(int sortis) {
    this.sortis = sortis;
  }
  public int getNombrePlacesLibres() {
    return this.NBPLACES - this.entres + this.sortis;
  }
  public int getEntres() {
    return entres;
  }
  public void setEntres(int entres) {
    this.entres = entres;
  }
  
  public void add(){
    this.setEntres(this.getEntres()+1);
    LOG.info("Le panneau d'affichage incrémente le nombre de vehicules entrés");
  }
  
  public void minus(){
    this.setSortis(this.sortis+1);
    LOG.info("Le panneau d'affichage incrémente le nombre de vehicules sortis");
  }
}