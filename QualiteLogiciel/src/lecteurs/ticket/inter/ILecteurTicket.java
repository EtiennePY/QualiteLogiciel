package lecteurs.ticket.inter;

import barriere.inter.IBarriereSortie;
import date.inter.IDateTicket;
import erreurs.BarriereErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.inter.ILecteurBancaire;
import systemeinfo.inter.ISystemeInformatique;
import ticket.inter.ITicket;

public interface ILecteurTicket {
	
	boolean restitutionTicket(final boolean retour);
	
	boolean verificationTicket(ISystemeInformatique sys, final IBarriereSortie barriere, final ILecteurBancaire lecteurBancaire) throws TicketErreur, BarriereErreur;
	
    ITicket donneTicket(IDateTicket date);
	
	boolean demandeInsertionTicket(final boolean detecte);
	ITicket getTicketClient();
	void setTicketClient(ITicket ticketClient);
	
}
