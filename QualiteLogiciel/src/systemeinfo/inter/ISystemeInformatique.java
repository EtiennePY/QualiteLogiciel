package systemeinfo.inter;


import java.util.Map;
import java.util.Set;

import abonnement.Abonnement;
import barriere.inter.IBarriereSortie;
import cartes.inter.IAbstractCarte;
import date.inter.IDateTicket;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import erreurs.TicketErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import ticket.inter.ITicket;

public interface ISystemeInformatique {
	
	boolean checkTicket(final ITicket ticket, final ILecteurTicket lecteur, final IBarriereSortie barriere, final ILecteurBancaire lecteurBancaire) throws TicketErreur, BarriereErreur;
	void ouvreBarriere(IBarriereSortie barriere) throws BarriereErreur;
	int calculPrix(IDateTicket date);
	void enregistreClientAbonne(Integer immatriculation, Integer id, Abonnement abonnement);
	Map<Integer, Abonnement> getAbonnements();
	Map<Integer, Integer> getImmatriculations();
	void enregistreClientNonAbonne(IDateTicket date);
	IDateTicket getDateDuJour();
	void setDateDuJour(IDateTicket dateDuJour);
	Set<IDateTicket> getDatesTicket();
	boolean checkAbonnement(final IAbstractCarte carte, final ILecteurCarteAbonnement lecteur, final IBarriereSortie barriere) throws CarteAbonnementErreur, BarriereErreur;
	}
