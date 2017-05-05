package detecteur;

import barriere.Barriere;
import client.Client;
import panneau.PanneauAffichage;
import systemeInformatique.SystemeInformatique;
import vehicule.Vehicule;

public class DetecteurSortie extends Detecteur {
	protected boolean present; 

	public DetecteurSortie() {
		this.present = false;
	}

	
	
	public boolean isPresent() {
		return present;
	}

	
	public void setPresent(boolean present) {
		this.present = present;
	}




	public void fermeBarriere(Barriere barriere) {
		System.out.println("Le detecteur provoque la fermeture de la barri�re");
		barriere.fermer();

	}

	
	public void metAJourPanneauAffichage(PanneauAffichage panneau) {
		System.out.println("Le d�tecteur met � jour le panneau d'affichage");

		panneau.minus();
		
	}

	public void detecteImmatriculationVehicule(Vehicule vehicule, SystemeInformatique sys) {
		if(sys.getIds().containsValue(vehicule.getImmatriculation())) {
			this.setPresent(true);
			System.out.println("Le d�tecteur a reconnu l'immatriculation : " + vehicule.getImmatriculation() + " du client.");	
		} else {
			System.out.println("Le d�tecteur n'a pas reconnu l'immatriculation : " + vehicule.getImmatriculation() + " du client.");	
		}
		}
		
	
	public void detecteClient(Client client) {
		this.setPresent(true);
		System.out.println("Le d�tecteur detecte le client " + client.toString());
		
	}
	
}
