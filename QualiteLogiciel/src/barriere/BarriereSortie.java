package barriere;

/*
 * 
 */
import client.ClientAbonne;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class BarriereSortie.
 */
public class BarriereSortie implements IBarriereSortie {
  
  /** The Constant LOG. */
  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
  
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
   */
  public void ouvrir() {
    this.setOuverte(true);
    LOG.info("La barrière s'ouvre");
  }
  
  /**
   * Fermer.
   */
  public void fermer() {
    this.setOuverte(false);
    LOG.info("La barrière se ferme");
  }
}
