package vehicule.impl;

import vehicule.inter.IVehicule;

public enum Vehicule implements IVehicule {
  MOTO, VOITURE, CAMIONETTE, CAMPINGCAR, CAMION;
  protected int immatriculation;

  public int getImmatriculation() {
    return immatriculation;
  }

  public void setImmatriculation(int immatriculation) {
    this.immatriculation = immatriculation;
  }
}
