package lecteurs.ticket.impl;

import date.impl.DateTicket;
import lecteurs.ticket.inter.ILecteurTicket;
import ticket.impl.Ticket;
import ticket.impl.TicketWith;
import ticket.impl.TicketWithout;

public class LecteurTicket implements ILecteurTicket {
	public LecteurTicket() {
		this.ticketClient = TicketWithout.instance();
	}
	private Ticket ticketClient;
	
	
	
	public Ticket restitutionTicket() {
		Ticket res = this.getTicketClient();
		this.ticketClient = TicketWithout.instance();
		return res;
	}
	
	
	
	public boolean verificationTicket(Ticket ticket) {
		System.out.println("Le lecteur de ticket vérifie le ticket.");
		// Role du SI ???
		return true;
		
	}
	
	public Ticket donneTicket(DateTicket date) {
		return new TicketWith(date);
		
	}
	
	public void demandeInsertionTicket() {
		
	}
	

	public Ticket getTicketClient() {
		return ticketClient;
	}

	public void setTicketClient(Ticket ticketClient) {
		this.ticketClient = ticketClient;
	}
	

}
