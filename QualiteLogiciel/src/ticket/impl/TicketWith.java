package ticket.impl;

import date.inter.IDateTicket;
import ticket.inter.ITicketWith;

/**
 * The Class Ticket.
 */
public class TicketWith extends Ticket implements ITicketWith {

	
	private IDateTicket dateTicket;
	
	public TicketWith(IDateTicket dateTicket) {
		this.dateTicket = dateTicket;
	}

	public IDateTicket getDateTicket() {
		return dateTicket;
	}

	public void setDateTicket(IDateTicket dateTicket) {
		this.dateTicket = dateTicket;
	}


	public boolean isWith() {
		return true;
	}


	
	
	

}
