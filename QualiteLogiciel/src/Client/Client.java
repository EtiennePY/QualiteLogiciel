package client;

import java.util.List;

import abonnement.Abonnement;
import vehicule.Vehicule;

public abstract class Client implements IClient{
	protected List<Vehicule> vehicules;

	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	@Override
	public void sePlaceDevantBarriere() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demandeAbonnement(Client client, Vehicule vehicule, Abonnement abonnement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void payeAbonnement(int prix) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
