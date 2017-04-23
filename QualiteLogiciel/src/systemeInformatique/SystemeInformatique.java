package systemeInformatique;

import java.util.HashMap;

import abonnement.Abonnement;
import barriere.Barriere;
import carte.CarteAbonnement;
import ticket.Ticket;

public class SystemeInformatique implements ISystemeInformatique{
	protected HashMap<Integer, Integer> immatriculations;
	protected HashMap<Integer, Abonnement> ids;
	@Override
	public boolean checkAbonnement(CarteAbonnement carte) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void enregistrerDateHeure() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void leverBarriere(Barriere barriere) {
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
	public boolean mauvaiseCarteAbonnement(CarteAbonnement carte) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean carteAbonnementValide(CarteAbonnement carte) {
		// TODO Auto-generated method stub
		return false;
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
	
}
