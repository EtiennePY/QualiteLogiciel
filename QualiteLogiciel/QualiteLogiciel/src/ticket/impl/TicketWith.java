package ticket.impl;

import date.impl.DateTicket;
import ticket.inter.ITicketWith;

/**
 * The Class Ticket.
 */
public class TicketWith extends Ticket implements ITicketWith {

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
		// TODO Auto-generated method stub
		return true;
	}

}
