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
import ticket.inter.ITicket;

public class LecteurTicket implements ILecteurTicket {
	
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
	
	public LecteurTicket() {
		this.ticketClient = TicketWithout.instance();
	}
	private ITicket ticketClient;
	
	
	
	public boolean restitutionTicket(final boolean retour) {
		if(retour) {
			LOG.info("Un message s'affiche : \"OK\" sur l'écran du lecteur de ticket et le ticket sort" );
		} else {
			LOG.info("Un message s'affiche : \"Ticket erroné\" sur l'écran du lecteur de ticket et le ticket sort" );
		}
		return retour;
	}
	
	
	
	public boolean verificationTicket(ISystemeInformatique sys, final IBarriereSortie barriere, final ILecteurBancaire lecteurBancaire) throws TicketErreur, BarriereErreur {
		if (this.getTicketClient().isWith()) {
			this.setTicketClient(this.getTicketClient());
			LOG.info("Le lecteur de ticket reçoit le ticket.");
			final ITicket ticket = (ITicket) this.getTicketClient();
			return sys.checkTicket(ticket, this, barriere, lecteurBancaire);
		} else {
			throw new TicketErreur("Aucun ticket n'a ete insere !");
		}

	}
	
	public ITicket donneTicket(IDateTicket date) {
		return new TicketWith(date);
		
	}
	
	public boolean demandeInsertionTicket(final boolean detecte) {
		if (detecte) {
			LOG.info("Le lecteur de ticket demande l'insertion d'un ticket");
		}
		else {
			LOG.warning("Appel à l'écran du lecteur sans client");
		}
		return detecte;
	}
	

	public ITicket getTicketClient() {
		return ticketClient;
	}

	public void setTicketClient(ITicket ticketClient) {
		this.ticketClient = ticketClient;
	}
	

}
