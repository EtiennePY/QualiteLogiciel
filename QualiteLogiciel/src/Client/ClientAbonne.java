package client;

import java.util.List;

import carte.Carte;
import carte.CarteWithout;
import lecteur.LecteurTicketAbonnement;
import vehicule.Vehicule;

public class ClientAbonne extends Client {
	
	protected Carte carteAbonnement;
	
	public ClientAbonne(List<Vehicule> vehicules, Carte carteAbonnement) {
		super.vehicules = vehicules;
		this.carteAbonnement = carteAbonnement;
	}
	
	public void insereCarteAbonnement(LecteurTicketAbonnement lecteur) {
		System.out.println("Le client abonné a inséré sa carte d'abonnement.");
		lecteur.setCarteClient(this.getCarteAbonnement());
		this.setCarteAbonnement(CarteWithout.instance());
	}
	

	public Carte getCarteAbonnement() {
		return carteAbonnement;
	}

	public void setCarteAbonnement(Carte carteAbonnement) {
		this.carteAbonnement = carteAbonnement;
	}
}
