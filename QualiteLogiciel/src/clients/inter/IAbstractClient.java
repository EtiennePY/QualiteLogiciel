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
   *
   * @return the string
   */
  String sePlaceDevantBarriere();
  
  /**
   * Passe.
   *
   * @return the string
   */
  String passe();
  
  /**
  * Checks if is abonne.
  *
  * @return true, if is abonne
  */
  boolean isAbonne();
}
