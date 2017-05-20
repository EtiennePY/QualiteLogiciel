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
import ticket.inter.IAbstractTicket;

// TODO: Auto-generated Javadoc
/**
 * The Interface ISystemeInformatique.
 */
public interface ISystemeInformatique {
	
	/**
	 * Check ticket.
	 *
	 * @param ticket the ticket, lecteur, barriere, lecteurBancaire
	 * @return true, if successful
	 * @throws TicketErreur the ticket erreur
	 * @throws BarriereErreur the barriere erreur
	 */
	boolean checkTicket(final IAbstractTicket ticket, final ILecteurTicket lecteur, final IBarriereSortie barriere, final ILecteurBancaire lecteurBancaire) throws TicketErreur, BarriereErreur;
	
	/**
	 * Ouvre barriere.
	 *
	 * @param barriere the barriere
	 * @throws BarriereErreur the barriere erreur
	 */
	void ouvreBarriere(IBarriereSortie barriere) throws BarriereErreur;
	
	/**
	 * Calcul prix.
	 *
	 * @param date the date
	 * @return the int
	 */
	int calculPrix(IDateTicket date);
	
	/**
	 * Enregistre client abonne.
	 *
	 * @param immatriculation the immatriculation
	 * @param id the id
	 * @param abonnement the abonnement
	 */
	void enregistreClientAbonne(Integer immatriculation, Integer identifiant, Abonnement abonnement);
	
	/**
	 * Gets the abonnements.
	 *
	 * @return the abonnements
	 */
	Map<Integer, Abonnement> getAbonnements();
	
	/**
	 * Gets the immatriculations.
	 *
	 * @return the immatriculations
	 */
	Map<Integer, Integer> getImmatriculations();
	
	/**
	 * Enregistre client non abonne.
	 *
	 * @param date the date
	 */
	void enregistreClientNonAbonne(IDateTicket date);
	
	/**
	 * Gets the date du jour.
	 *
	 * @return the date du jour
	 */
	IDateTicket getDateDuJour();
	
	/**
	 * Sets the date du jour.
	 *
	 * @param dateDuJour the new date du jour
	 */
	void setDateDuJour(IDateTicket dateDuJour);
	
	/**
	 * Gets the dates ticket.
	 *
	 * @return the dates ticket
	 */
	Set<IDateTicket> getDatesTicket();
	
	/**
	 * Check abonnement.
	 *
	 * @param carte, lecteur, barriere
	 * @return true, if successful
	 * @throws CarteAbonnementErreur, BarriereErreur
	 */
	boolean checkAbonnement(final IAbstractCarte carte, final ILecteurCarteAbonnement lecteur, final IBarriereSortie barriere) throws CarteAbonnementErreur, BarriereErreur;
	}
