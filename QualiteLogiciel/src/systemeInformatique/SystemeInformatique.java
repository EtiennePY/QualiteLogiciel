package systemeInformatique;

import java.util.HashMap;
import abonnement.Abonnement;
import barriere.Barriere;
import carte.Carte;
import ticket.Ticket;

public class SystemeInformatique implements ISystemeInformatique{
	//a partir de l'immatriculation trouver l'abonnement
	protected HashMap<Integer, Abonnement> abonnements;
	
	//a partir de l'id trouver l'immatriculation
	protected HashMap<Integer, Integer> ids;

	public SystemeInformatique() {
		this.abonnements = new HashMap<Integer, Abonnement>();
		this.ids = new HashMap<Integer, Integer>();

	}
	public HashMap<Integer, Abonnement> getAbonnements() {
		return abonnements;
	}
	public void setAbonnements(HashMap<Integer, Abonnement> abonnements) {
		this.abonnements = abonnements;
	}
	public HashMap<Integer, Integer> getIds() {
		return ids;
	}
	public void setIds(HashMap<Integer, Integer> ids) {
		this.ids = ids;
	}
	@Override
	public boolean checkAbonnement(Carte carte){
		boolean result = ids.containsKey(carte.getId());
		 if(result) {
			 this.carteAbonnementValide(carte);
		 }
		 else {
			 this.mauvaiseCarteAbonnement(carte);
		 }
		return result;
			
	}
	@Override
	public void enregistrerDateHeure() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int calcuPrix() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int donnePrixAPayer(int prix) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean mauvaiseCarteAbonnement(Carte carte) {
		System.out.println("La carte ayant pour id "+carte.getId()+" n'est pas reconnue par le système informatique");
		return false;
	}
	@Override
	public boolean carteAbonnementValide(Carte carte) {
		System.out.println("La carte ayant pour id "+carte.getId()+" est reconnue par le système informatique");
		return true;
	}
	@Override
	public boolean ticketNonValide(Ticket ticket) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void addId(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteId(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void changeAbonnement(int id, Abonnement abonnement) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ouvreBarriere(Barriere barriere) {
		System.out.println("Le système informatique provoque l'ouverture de la barrière");
		barriere.ouvrir();		

	}
	
}
