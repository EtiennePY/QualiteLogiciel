package ticket.impl;

import date.inter.IDateTicket;
import ticket.inter.ITicketWithout;

public class TicketWithout extends Ticket implements ITicketWithout {
	private final static TicketWithout TICKETWITHOUT = new TicketWithout();
	public TicketWithout() {
		// TODO Auto-generated constructor stub
	}

	public boolean isTicketWith() {
		return false;
	}
	public static TicketWithout instance(){
		return TicketWithout.TICKETWITHOUT;
	}

	public int calculPrix(IDateTicket dateDuJour) {
		return 0;
	}

}
