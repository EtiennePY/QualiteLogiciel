package lecteurs.ticket.inter;

import date.impl.DateTicket;
import ticket.impl.Ticket;
import ticket.inter.ITicket;

public interface ILecteurTicket {
	
	public Ticket restitutionTicket();
	
	public boolean verificationTicket(ITicket ticketClient);
	
	public Ticket donneTicket(DateTicket date);
	
	public void demandeInsertionTicket();
	
	
}
