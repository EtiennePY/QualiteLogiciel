package ticket.inter;

import date.inter.IDateTicket;

public interface ITicket {

	boolean isTicketWith();
	
	int calculPrix(IDateTicket dateDuJour);

}
