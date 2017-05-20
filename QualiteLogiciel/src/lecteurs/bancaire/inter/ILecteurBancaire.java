package lecteurs.bancaire.inter;

import banque.inter.IBanque;
import cartes.inter.IAbstractCarte;
import cartes.inter.ICarteBancaire;
import erreurs.BanqueErreur;
import erreurs.TicketErreur;
import lecteurs.ticket.inter.ILecteurTicket;
import systemeinfo.inter.ISystemeInformatique;

public interface ILecteurBancaire {
	
	boolean demandeInsertionCarte(final boolean ticketOk);
	
	boolean contacterBanque(ICarteBancaire carte, int prix);
	
	boolean restitutionCarteBancaire(final boolean retour);
	
	void setBanque(IBanque banque);
	IAbstractCarte getCarteBancaireClient();
	

	public void setCarteBancaireClient(IAbstractCarte carteClient);

	boolean realiseTransaction(ISystemeInformatique sys, ILecteurTicket lecteurTicket) throws TicketErreur, BanqueErreur;
}
