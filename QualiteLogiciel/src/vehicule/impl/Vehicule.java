/*
 * 
 */
package vehicule.impl;

import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Enum Vehicule.
 */
public class Vehicule implements IVehicule {
 
	public Vehicule(CategorieVehicule categorie, Integer immatriculation) {
		this.categorie = categorie;
		this.immatriculation = immatriculation;
	}

/** The immatriculation. */
  private int immatriculation;
  private final CategorieVehicule categorie;
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
  
  public CategorieVehicule getCategorie() {
		return categorie;
	}
}
