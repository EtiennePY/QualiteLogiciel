package clients.inter;

import cartes.inter.IAbstractCarte;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import ticket.inter.ITicket;

public interface IClientNonAbonne extends IAbstractClient {
	
	
	void insereTicket(final ILecteurTicket lecteurTicket) throws TicketErreur;
	
	void insereCarteBancaire(ILecteurBancaire carte) throws CarteBancaireErreur;
	
	IAbstractCarte getCarteBancaire();
	
	void setCarteBancaire(IAbstractCarte carteBancaire);
	
	ITicket getTicket();
	
	void setTicket(ITicket ticket);
}
