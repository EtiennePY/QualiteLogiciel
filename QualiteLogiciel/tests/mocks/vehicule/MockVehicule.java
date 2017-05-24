package mocks.vehicule;

import vehicule.impl.CategorieVehicule;
import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Enum Vehicule.
 */
public class MockVehicule implements IVehicule {

  /** The immatriculation. */
  private int immatriculation;
  
  /** The categorie. */
  private final CategorieVehicule categorie;
  
  /**
   * Instantiates a new vehicule.
   *
   * @param categorie the categorie
   * @param immatriculation the immatriculation
   */
  public MockVehicule(final CategorieVehicule categorie, final Integer immatriculation) {
    this.categorie = categorie;
    this.immatriculation = immatriculation;
  }

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
  
  /**
  * Gets the categorie.
  *
  * @return the categorie
  */
  public CategorieVehicule getCategorie() {
    return categorie;
  }
}
