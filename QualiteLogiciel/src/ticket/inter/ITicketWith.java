package ticket.inter;

import date.inter.IDateTicket;

public interface ITicketWith extends ITicket {
	IDateTicket getDateTicket();
	void setDateTicket(IDateTicket dateTicket);
}
