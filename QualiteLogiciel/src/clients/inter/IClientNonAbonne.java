package clients.inter;

import cartes.inter.IAbstractCarte;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import ticket.inter.IAbstractTicket;

// TODO: Auto-generated Javadoc
/**
 * The Interface IClientNonAbonne.
 */
public interface IClientNonAbonne extends IAbstractClient {
	
	
	/**
	 * Insere ticket.
	 *
	 * @param lecteurTicket the lecteur ticket
	 * @throws TicketErreur the ticket erreur
	 */
	void insereTicket(final ILecteurTicket lecteurTicket) throws TicketErreur;
	
	/**
	 * Insere carte bancaire.
	 *
	 * @param carte the carte
	 * @throws CarteBancaireErreur the carte bancaire erreur
	 */
	void insereCarteBancaire(ILecteurBancaire carte) throws CarteBancaireErreur;
	
	/**
	 * Gets the carte bancaire.
	 *
	 * @return the carte bancaire
	 */
	IAbstractCarte getCarteBancaire();
	
	/**
	 * Sets the carte bancaire.
	 *
	 * @param carteBancaire the new carte bancaire
	 */
	void setCarteBancaire(IAbstractCarte carteBancaire);
	
	/**
	 * Gets the ticket.
	 *
	 * @return the ticket
	 */
	IAbstractTicket getTicket();
	
	/**
	 * Sets the ticket.
	 *
	 * @param ticket the new ticket
	 */
	void setTicket(IAbstractTicket ticket);
}
