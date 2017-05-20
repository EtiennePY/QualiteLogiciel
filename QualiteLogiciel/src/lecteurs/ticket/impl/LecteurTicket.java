package lecteurs.ticket.impl;

import java.util.logging.Logger;

import barriere.inter.IBarriereSortie;
import clients.impl.ClientAbonne;
import date.inter.IDateTicket;
import erreurs.BarriereErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import systemeinfo.inter.ISystemeInformatique;
import ticket.impl.TicketWith;
import ticket.impl.TicketWithout;
import ticket.inter.IAbstractTicket;

// TODO: Auto-generated Javadoc
/**
 * The Class LecteurTicket.
 */
public class LecteurTicket implements ILecteurTicket {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
	
	/** The ticket client. */
	private IAbstractTicket ticketClient;
	
	/**
	 * Instantiates a new lecteur ticket.
	 */
	public LecteurTicket() {
		this.ticketClient = TicketWithout.instance();
	}
	

	
	
	/**
	 * Restitution ticket.
	 *
	 * @param retour the retour
	 * @return true, if successful
	 */
	public boolean restitutionTicket(final boolean retour) {
		if(retour) {
			LOG.info("Un message s'affiche : \"OK\" sur l'écran du lecteur de ticket et le ticket sort" );
		} else {
			LOG.info("Un message s'affiche : \"Ticket erroné\" sur l'écran du lecteur de ticket et le ticket sort" );
		}
		return retour;
	}
	
	
	
	/**
	 * Verification ticket.
	 *
	 * @param sys the sys, barriere the barriere
	 * @param lecteurBancaire the lecteur bancaire
	 * @return true, if successful
	 * @throws TicketErreur, BarriereErreur 
	 */
	public boolean verificationTicket(final ISystemeInformatique sys, final IBarriereSortie barriere, final ILecteurBancaire lecteurBancaire) throws TicketErreur, BarriereErreur {
		if (this.getTicketClient().isWith()) {
			this.setTicketClient(this.getTicketClient());
			LOG.info("Le lecteur de ticket reçoit le ticket.");
			final IAbstractTicket ticket = (IAbstractTicket) this.getTicketClient();
			return sys.checkTicket(ticket, this, barriere, lecteurBancaire);
		} else {
			throw new TicketErreur("Aucun ticket n'a ete insere !");
		}

	}
	
    /**
     * Donne ticket.
     *
     * @param date the date
     * @return the i ticket
     */
	public IAbstractTicket donneTicket(final IDateTicket date) {
		return new TicketWith(date);
		
	}
	
	/**
	 * Demande insertion ticket.
	 *
	 * @param detecte the detecte
	 * @return true, if successful
	 */
	public boolean demandeInsertionTicket(final boolean detecte) {
		if (detecte) {
			LOG.info("Le lecteur de ticket demande l'insertion d'un ticket");
		}
		else {
			LOG.warning("Appel à l'écran du lecteur sans client");
		}
		return detecte;
	}
	

	/**
	 * Gets the ticket client.
	 *
	 * @return the ticket client
	 */
	public IAbstractTicket getTicketClient() {
		return ticketClient;
	}
	
	/**
	 * Sets the ticket client.
	 *
	 * @param ticketClient the new ticket client
	 */
	public void setTicketClient(final IAbstractTicket ticketClient) {
		this.ticketClient = ticketClient;
	}
	

}
