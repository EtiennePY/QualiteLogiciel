package clients.inter;

import ticket.impl.Ticket;

public interface IClientNonAbonne extends IAbstractClient {
	
	Ticket insereTicket();

}
