package mocks.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import clients.inter.IAbstractClient;
import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractClient.
 */
public abstract class MockAbstractClient implements IAbstractClient {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(MockAbstractClient.class.getName());

  /** The vehicules. */
  protected final List<IVehicule> vehicules;
  
  /**
  * Instantiates a new abstract client.
  */
  public MockAbstractClient() {
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
   *
   * @return the string
   */
  public String sePlaceDevantBarriere() {
    LOG.info("Le client se positionne devant la barrière");
    return "Le client se positionne devant la barrière";
  }

  /**
   * Passe.
   *
   * @return the string
   */
  public String passe() {
    LOG.info("Le client passe");
    return "Le client passe";
  }
  
  /**
   * Checks if is abonne.
   *
   * @return true, if is abonne
   */
  public abstract boolean isAbonne();
}
