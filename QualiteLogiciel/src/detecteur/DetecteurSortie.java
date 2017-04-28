package detecteur;

import client.IClient;
import vehicule.Vehicule;

public class DetecteurSortie extends Detecteur {
	public DetecteurSortie() {
		
	}
	public void detecteImmatriculationVehicule(Vehicule vehicule, IClient client) {
		super.setPresent(true);
		System.out.println("Le d�tecteur a reconnu l'immatriculation : " + vehicule.getImmatriculation() + " du client " + client.toString());	
	}
	public void detecteClient(IClient client) {
		super.setPresent(true);
		System.out.println("Le d�tecteur detecte le client " + client.toString());
		
	}
	
}
