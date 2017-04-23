package client;

import java.util.Set;

import abonnement.Abonnement;
import vehicule.Vehicule;

public abstract class Client implements IClient{
	protected Set<Vehicule> vehicules;

	public Set<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(Set<Vehicule> vehicules) {
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
