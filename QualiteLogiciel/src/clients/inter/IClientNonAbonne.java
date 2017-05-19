package clients.inter;

import cartes.inter.ICarteBancaire;
import lecteurs.bancaire.inter.ILecteurBancaire;
import ticket.impl.Ticket;
import ticket.inter.ITicket;

public interface IClientNonAbonne extends IAbstractClient {
	
	
	ITicket insereTicket();
	
	void insereCarteBancaire(ILecteurBancaire carte);
	
	ICarteBancaire getCarteBancaire();
	
	void setCarteBancaire(ICarteBancaire carteBancaire);
	
	ITicket getTicket();
	
	void setTicket(ITicket ticket);
}
