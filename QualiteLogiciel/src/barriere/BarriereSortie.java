package barriere;

import java.util.logging.Logger;

import client.ClientAbonne;

public class BarriereSortie {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

  public BarriereSortie() {
    this.ouverte = false;
  }
  
  private boolean ouverte;

  public boolean isOuverte() {
    return ouverte;
  }

  public void setOuverte(boolean ouverte) {
    this.ouverte = ouverte;
  }
  
  public void ouvrir() {
    this.setOuverte(true);
    LOG.info("La barrière s'ouvre");
  }
  
  public void fermer() {
    this.setOuverte(false);
    LOG.info("La barrière se ferme");
  }
}
