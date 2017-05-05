package lecteur;

import carte.Carte;
import error.TicketError;
import ticket.Ticket;

public abstract class Lecteur implements ILecteur {


	@Override
	public Ticket restitutionTicket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verificationTicket(Ticket ticket) throws TicketError {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Carte restitutionCarte() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contacterBanque(int prix) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void demandeInsertionCarte() {
	}
}
