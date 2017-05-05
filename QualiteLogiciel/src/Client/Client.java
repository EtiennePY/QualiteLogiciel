package client;

import java.util.List;

import vehicule.Vehicule;

public abstract class Client {
	protected List<Vehicule> vehicules;
	
	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
		for (Vehicule vehicule : this.vehicules) {
			vehicule.setImmatriculation((int)(Math.random()*10000));	
		}	
	}

	
	public void sePlaceDevantBarriere() {
		System.out.println("Le client abonn� se positionne devant la barri�re.");
	}

	
	public void passe() {
		System.out.println("Le client passe");		
	}

	
	
}
