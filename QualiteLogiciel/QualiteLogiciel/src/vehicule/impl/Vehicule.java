/*
 * 
 */
package vehicule.impl;

import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Enum Vehicule.
 */
public enum Vehicule implements IVehicule {
  
  /** The moto. */
  MOTO, 
 /** The voiture. */
 VOITURE, 
 /** The camionette. */
 CAMIONETTE, 
 /** The campingcar. */
 CAMPINGCAR, 
 /** The camion. */
 CAMION;
  
  /** The immatriculation. */
  protected int immatriculation;

	/**
	 * Gets the immatriculation.
	 *
	 * @return the immatriculation
	 */
  public int getImmatriculation() {
    return immatriculation;
  }

	/**
	 * Sets the immatriculation.
	 *
	 * @param immatriculation the new immatriculation
	 */
  public void setImmatriculation(final int immatriculation) {
    this.immatriculation = immatriculation;
  }
}
