/*
 * 
 */
package clients.inter;

import java.util.List;

import vehicule.inter.IVehicule;

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
   * Se place devant barriere.
   */
  String sePlaceDevantBarriere();
  
  /**
   * Passe.
   */
  String passe();
  
  abstract boolean isAbonne();
}
