package client;

import java.util.List;

import vehicule.Vehicule;

public abstract class Client implements IClient{
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

	@Override
	public void sePlaceDevantBarriere() {
		System.out.println("Le client abonné se positionne devant la barrière.");
	}

	@Override
	public void passe() {
		System.out.println("Le client passe");		
	}

	
	
}
