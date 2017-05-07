package lecteur;

import date.Date;
import ticket.Ticket;
import ticket.TicketWith;
import ticket.TicketWithout;

public class LecteurTicket extends Lecteur {
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
	
	public Ticket donneTicket(Date date) {
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
