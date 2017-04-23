package client;

import carte.Carte;
import carte.CarteAbonnement;

public class ClientAbonne extends Client {
	
	protected CarteAbonnement carteAbonnement;
	
	public void insereCarteAbonnement(CarteAbonnement carte) {
		
	}
	
	public void demandeResiliation(CarteAbonnement carte) {
		
	}

	public CarteAbonnement getCarteAbonnement() {
		return carteAbonnement;
	}

	public void setCarteAbonnement(CarteAbonnement carteAbonnement) {
		this.carteAbonnement = carteAbonnement;
	}
}
