/*
 * 
 */
package clients.impl;

import java.util.ArrayList;
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
  protected final List<IVehicule> vehicules;
  
  public AbstractClient() {
	  this.vehicules = new ArrayList<IVehicule>();
  }
  /**
   * Gets the vehicules.
   *
   * @return the vehicules
   */
  public List<IVehicule> getVehicules() {
    return vehicules;
  }


  
  /**
   * Se place devant barriere.
   */
  public String sePlaceDevantBarriere() {
	String texte = "Le client se positionne devant la barrière";
    LOG.info(texte);
    return texte;
  }

  /**
   * Passe.
   */
  public String passe() {
    String texte = "Le client passe";
    LOG.info(texte);
    return texte;
  }
  
  public abstract boolean isAbonne();
}
