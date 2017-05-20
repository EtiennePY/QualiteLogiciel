package lecteurs.ticket.inter;

import barriere.inter.IBarriereSortie;
import date.inter.IDateTicket;
import erreurs.BarriereErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.inter.ILecteurBancaire;
import systemeinfo.inter.ISystemeInformatique;
import ticket.inter.IAbstractTicket;

// TODO: Auto-generated Javadoc
/**
 * The Interface ILecteurTicket.
 */
public interface ILecteurTicket {
	
	/**
	 * Restitution ticket.
	 *
	 * @param retour the retour
	 * @return true, if successful
	 */
	boolean restitutionTicket(final boolean retour);
	
	/**
	 * Verification ticket.
	 *
	 * @param sys the sys, barriere the barriere
	 * @param lecteurBancaire the lecteur bancaire
	 * @return true, if successful
	 * @throws TicketErreur, BarriereErreur 
	 */
	boolean verificationTicket(ISystemeInformatique sys, final IBarriereSortie barriere, final ILecteurBancaire lecteurBancaire) throws TicketErreur, BarriereErreur;
	
    /**
     * Donne ticket.
     *
     * @param date the date
     * @return the i ticket
     */
    IAbstractTicket donneTicket(IDateTicket date);
	
	/**
	 * Demande insertion ticket.
	 *
	 * @param detecte the detecte
	 * @return true, if successful
	 */
	boolean demandeInsertionTicket(final boolean detecte);
	
	/**
	 * Gets the ticket client.
	 *
	 * @return the ticket client
	 */
	IAbstractTicket getTicketClient();
	
	/**
	 * Sets the ticket client.
	 *
	 * @param ticketClient the new ticket client
	 */
	void setTicketClient(IAbstractTicket ticketClient);
	
}
