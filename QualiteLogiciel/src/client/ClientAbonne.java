package client;

import java.util.List;

import carte.CarteAbonnement;
import vehicule.Vehicule;

public class ClientAbonne extends Client {
	
	protected CarteAbonnement carteAbonnement;
	
	public ClientAbonne(List<Vehicule> vehicules, CarteAbonnement carteAbonnement) {
		super.vehicules = vehicules;
		this.carteAbonnement = carteAbonnement;
	}
	
	public void insereCarteAbonnement() {
		System.out.println("Le client abonné a inséré sa carte d'abonnement.");
	}
	

	public CarteAbonnement getCarteAbonnement() {
		return carteAbonnement;
	}

	public void setCarteAbonnement(CarteAbonnement carteAbonnement) {
		this.carteAbonnement = carteAbonnement;
	}
}
