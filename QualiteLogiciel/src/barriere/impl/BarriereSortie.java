package barriere.impl;

import barriere.inter.IBarriereSortie;
import erreurs.BarriereErreur;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class BarriereSortie.
 */
public class BarriereSortie implements IBarriereSortie {
  
  /** The Constant LOG. */
  private static final Logger LOG = Logger.getLogger(BarriereSortie.class.getName());
  
  /** The ouverte. */
  private boolean ouverte;
  
  /**
   * Instantiates a new barriere sortie.
   */
  public BarriereSortie() {
    this.ouverte = false;
  }

  /**
   * Checks if is ouverte.
   *
   * @return true, if is ouverte
   */
  public boolean isOuverte() {
    return ouverte;
  }


  /**
   * Sets the ouverte.
   *
   * @param ouverte the new ouverte
   */
  public void setOuverte(final boolean ouverte) {
    this.ouverte = ouverte;
  }
  
  /**
   * Ouvrir.
   * @throws BarriereErreur 
   * 
   */
  public void ouvrir() throws BarriereErreur {
    if (this.isOuverte()) {
      throw new BarriereErreur("La barriere est deja ouverte !");
    }
    this.setOuverte(true);
    LOG.info("La barrière s'ouvre");
  }
  
  /**
   * Fermer.
   * @throws BarriereErreur 
   * 
   */
  public void fermer() throws BarriereErreur {
    if (!this.isOuverte()) {
      throw new BarriereErreur("La barriere est deja fermee !");
    }
    this.setOuverte(false);
    LOG.info("La barrière se ferme");
  }
}
