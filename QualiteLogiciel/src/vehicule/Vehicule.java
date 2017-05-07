package vehicule;

public enum Vehicule {
  MOTO, VOITURE, CAMIONETTE, CAMPINGCAR, CAMION;
  protected int immatriculation;

  public int getImmatriculation() {
    return immatriculation;
  }

  public void setImmatriculation(int immatriculation) {
    this.immatriculation = immatriculation;
  }
}
