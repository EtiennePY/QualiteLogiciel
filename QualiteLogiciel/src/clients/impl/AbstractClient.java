/*
 * 
 */
package clients.impl;

import java.util.List;
import java.util.logging.Logger;

import clients.inter.IAbstractClient;
import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractClient.
 */
public abstract class AbstractClient implements IAbstractClient {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(AbstractClient.class.getName());

  /** The vehicules. */
  protected List<IVehicule> vehicules;
  
  /**
   * Instantiates a new abstract client.
   */
  public AbstractClient() {}
  
  /**
   * Gets the vehicules.
   *
   * @return the vehicules
   */
  public List<IVehicule> getVehicules() {
    return vehicules;
  }

  /**
   * Sets the vehicules.
   *
   * @param vehicules the new vehicules
   */
  public void setVehicules(final List<IVehicule> vehicules) {
    this.vehicules = vehicules;
    for (final IVehicule vehicule : this.vehicules) {
      vehicule.setImmatriculation((int)(Math.random()*10000));  
    }  
  }
  
  /**
   * Se place devant barriere.
   */
  public void sePlaceDevantBarriere() {
    LOG.info("Le client se positionne devant la barrière.");
  }

  /**
   * Passe.
   */
  public void passe() {
    LOG.info("Le client passe");    
  }

}
