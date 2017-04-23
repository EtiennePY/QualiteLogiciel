package client;

import java.util.Set;

import carte.CarteAbonnement;
import vehicule.Vehicule;

public class ClientAbonne extends Client {
	
	protected CarteAbonnement carteAbonnement;
	
	public ClientAbonne(Set<Vehicule> vehicules, CarteAbonnement carteAbonnement) {
		super.vehicules = vehicules;
		this.carteAbonnement = carteAbonnement;
	}
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
