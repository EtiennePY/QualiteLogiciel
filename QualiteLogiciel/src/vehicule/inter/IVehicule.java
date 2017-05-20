/*
 * 
 */
package vehicule.inter;

import vehicule.impl.CategorieVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Interface IVehicule.
 */
public interface IVehicule {
	  
  	/**
  	 * Gets the immatriculation.
  	 *
  	 * @return the immatriculation
  	 */
  	int getImmatriculation();
	  
  	/**
  	 * Sets the immatriculation.
  	 *
  	 * @param immatriculation the new immatriculation
  	 */
  	void setImmatriculation(int immatriculation);
  	
  	/**
	  * Gets the categorie.
	  *
	  * @return the categorie
	  */
	  CategorieVehicule getCategorie();
}
