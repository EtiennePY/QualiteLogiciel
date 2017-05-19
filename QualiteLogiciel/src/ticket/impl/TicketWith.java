package ticket.impl;

import java.util.logging.Logger;

import clients.impl.ClientAbonne;
import date.impl.DateTicket;
import date.inter.IDateTicket;
import ticket.inter.ITicketWith;

/**
 * The Class Ticket.
 */
public class TicketWith extends Ticket implements ITicketWith {

	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
	
	private DateTicket dateTicket;
	
	public DateTicket getDateTicket() {
		return dateTicket;
	}

	public void setDateTicket(DateTicket dateTicket) {
		this.dateTicket = dateTicket;
	}

	public TicketWith(DateTicket dateTicket) {
		this.dateTicket = dateTicket;
	}

	public boolean isTicketWith() {
		return true;
	}

	public int calculPrix(IDateTicket dateDuJour) {
		LOG.info("Calcul du prix en fonction de la durée de stationnement ...");
		return (dateDuJour.getHeure()-this.getDateTicket().getHeure())+(dateDuJour.getJour()-this.getDateTicket().getJour())*24;
	}
	
	

}
