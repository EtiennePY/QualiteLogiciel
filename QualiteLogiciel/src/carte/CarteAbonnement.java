package carte;

import abonnement.Abonnement;

public class CarteAbonnement extends Carte {

	protected Abonnement abonnement;
	
	public CarteAbonnement(int id, Abonnement abonnement){
		super.id=id;
		this.abonnement = abonnement;
	}

	public Abonnement getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}
}
