package lecteur;

import carte.Carte;
import ticket.Ticket;

public class Lecteur implements ILecteur {

	@Override
	public void demandeInsertionCarte(Carte carte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ticket restitutionTicket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verificationTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Carte restitutionCarte() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contacterBanque(Carte carte) {
		// TODO Auto-generated method stub
		return false;
	}
  
}
