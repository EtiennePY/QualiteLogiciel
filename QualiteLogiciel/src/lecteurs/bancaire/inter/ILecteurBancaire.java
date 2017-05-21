package lecteurs.bancaire.inter;

import banque.inter.IBanque;
import barriere.inter.IBarriereSortie;
import cartes.inter.IAbstractCarte;
import cartes.inter.ICarteBancaire;
import erreurs.BarriereErreur;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import lecteurs.ticket.inter.ILecteurTicket;
import systemeinfo.inter.ISystemeInformatique;

// TODO: Auto-generated Javadoc
/**
 * The Interface ILecteurBancaire.
 */
public interface ILecteurBancaire {
	
	/**
	 * Demande insertion carte.
	 *
	 * @param ticketOk the ticket ok
	 * @return true, if successful
	 */
	boolean demandeInsertionCarte(final boolean ticketOk);
	
	/**
	 * Contacter banque.
	 *
	 * @param carte the carte
	 * @param prix the prix
	 * @return true, if successful
	 */
	boolean contacterBanque(ICarteBancaire carte, int prix);
	
	/**
	 * Restitution carte bancaire.
	 *
	 * @param retour the retour
	 * @return true, if successful
	 */
	boolean restitutionCarteBancaire(final boolean retour);
	

	/**
	 * Gets the banque.
	 *
	 * @return the banque
	 */
	IBanque getBanque();
	
	/**
	 * Sets the banque.
	 *
	 * @param banque the new banque
	 */
	void setBanque(IBanque banque);
	
	/**
	 * Gets the carte bancaire.
	 *
	 * @return the carte bancaire
	 */
	IAbstractCarte getCarteBancaire();
	

	/**
	 * Sets the carte bancaire.
	 *
	 * @param carteClient the new carte bancaire
	 */
	void setCarteBancaire(IAbstractCarte carteClient);

	/**
	 * Realise transaction.
	 *
	 * @param sys the sys, lecteurTicket the lecteur ticket
	 * @return true, if successful
	 * @throws TicketErreur the ticket erreur
	 * @throws BanqueErreur the banque erreur
	 * @throws BarriereErreur 
	 * @throws CarteBancaireErreur 
	 */
	boolean realiseTransaction(ISystemeInformatique sys, ILecteurTicket lecteurTicket, final IBarriereSortie barriere) throws TicketErreur, BarriereErreur, CarteBancaireErreur;
}
