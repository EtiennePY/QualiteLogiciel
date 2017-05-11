/*
 * 
 */
package client;

import java.util.List;
import vehicule.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAbstractClient.
 */
public interface IAbstractClient {
  
  /**
   * Gets the vehicules.
   *
   * @return the vehicules
   */
  List<IVehicule> getVehicules();
  
  /**
   * Sets the vehicules.
   *
   * @param vehicules the new vehicules
   */
  void setVehicules(final List<IVehicule> vehicules);
  
  /**
   * Se place devant barriere.
   */
  void sePlaceDevantBarriere();
  
  /**
   * Passe.
   */
  void passe();
}
