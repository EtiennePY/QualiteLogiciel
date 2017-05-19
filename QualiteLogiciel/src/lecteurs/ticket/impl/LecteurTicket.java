package lecteurs.ticket.impl;

import java.util.logging.Logger;

import clients.impl.ClientAbonne;
import date.impl.DateTicket;
import lecteurs.ticket.inter.ILecteurTicket;
import ticket.impl.Ticket;
import ticket.impl.TicketWith;
import ticket.impl.TicketWithout;
import ticket.inter.ITicket;

public class LecteurTicket implements ILecteurTicket {
	
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
	
	public LecteurTicket() {
		this.ticketClient = TicketWithout.instance();
	}
	private Ticket ticketClient;
	
	
	
	public Ticket restitutionTicket() {
		Ticket res = this.getTicketClient();
		this.ticketClient = TicketWithout.instance();
		return res;
	}
	
	
	
	public boolean verificationTicket(ITicket ticket) {
		LOG.info("Le lecteur de ticket vérifie le ticket.");
		return ticket.isTicketWith();
		
	}
	
	public Ticket donneTicket(DateTicket date) {
		return new TicketWith(date);
		
	}
	
	public void demandeInsertionTicket() {
		LOG.info("Le lecteur de ticket demande l'insertion d'un ticket");
	}
	

	public Ticket getTicketClient() {
		return ticketClient;
	}

	public void setTicketClient(Ticket ticketClient) {
		this.ticketClient = ticketClient;
	}
	

}
