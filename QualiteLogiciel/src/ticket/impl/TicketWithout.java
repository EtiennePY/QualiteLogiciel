package ticket.impl;

import ticket.inter.ITicketWithout;

public class TicketWithout extends Ticket implements ITicketWithout {
	private final static TicketWithout TICKETWITHOUT = new TicketWithout();
	public TicketWithout() {
		// TODO Auto-generated constructor stub
	}

	public boolean isWith() {
		return false;
	}
	public static TicketWithout instance(){
		return TicketWithout.TICKETWITHOUT;
	}

	

}
