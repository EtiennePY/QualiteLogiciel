/*
 * 
 */
package systemeinfo.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import abonnement.Abonnement;
import barriere.inter.IBarriereSortie;
import cartes.impl.AbstractCarteWith;
import cartes.inter.IAbstractCarte;
import cartes.inter.IAbstractCarteWith;
import clients.impl.ClientAbonne;
import date.impl.DateTicket;
import date.inter.IDateTicket;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import erreurs.TicketErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import systemeinfo.inter.ISystemeInformatique;
import ticket.inter.ITicket;
import ticket.inter.ITicketWith;

public class SystemeInformatique implements ISystemeInformatique {
	/** The logger. */
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

	//a partir de l'immatriculation trouver l'abonnement
		private final Map<Integer, Abonnement> abonnements;


		//a partir de l'id trouver l'immatriculation
		private final Map<Integer, Integer> immatriculations;
		
		private final Set<IDateTicket> datesTicket;
		private IDateTicket dateDuJour = new DateTicket(16,04);
	public SystemeInformatique() {
		this.abonnements = new HashMap<Integer, Abonnement>();
		this.immatriculations = new HashMap<Integer, Integer>();
		this.datesTicket = new HashSet<IDateTicket>();

	}
	public Map<Integer, Abonnement> getAbonnements() {
		return abonnements;
	}



	public Map<Integer, Integer> getImmatriculations() {
		return immatriculations;
	}


	public void enregistreClientAbonne(Integer immatriculation, Integer id, Abonnement abonnement) {
		this.getImmatriculations().put(id, immatriculation);
		this.getAbonnements().put(immatriculation, abonnement);
	}
	public void enregistreClientNonAbonne(IDateTicket date) {
		this.getDatesTicket().add(date);
	}
	public IDateTicket getDateDuJour() {
		return dateDuJour;
	}
	public void setDateDuJour(IDateTicket dateDuJour) {
		this.dateDuJour = dateDuJour;
	}
	public Set<IDateTicket> getDatesTicket() {
		return datesTicket;
	}
	public boolean checkAbonnement(final IAbstractCarte carte, final ILecteurCarteAbonnement lecteur, final IBarriereSortie barriere) throws CarteAbonnementErreur, BarriereErreur {
		if(carte.isWith()){
			final IAbstractCarteWith carteWith = (AbstractCarteWith) carte;
			final Integer identifiant = carteWith.getIdentifiant();
			final boolean result = immatriculations.containsKey(identifiant);
			
			if(result) {
				LOG.info("La carte ayant pour id " + immatriculations + " est reconnue par le système informatique");
				this.ouvreBarriere(barriere);

			}
			else {
				LOG.info("La carte ayant pour id " + identifiant + " n'est pas reconnue par le système informatique");
			} 
			lecteur.restitutionCarte(result);
			return result;
		}
		else {
			throw new CarteAbonnementErreur("Aucune carte d'abonnement n'a ete inseree !");
		}
	}


	

	public void ouvreBarriere(final IBarriereSortie barriere) throws BarriereErreur {
		LOG.info("Le système informatique provoque l'ouverture de la barrière");
		barriere.ouvrir();    

	}

	public boolean checkTicket(final ITicket ticket, final ILecteurTicket lecteur, final IBarriereSortie barriere, final ILecteurBancaire lecteurBancaire) throws TicketErreur, BarriereErreur {
		if(ticket.isWith()){
			final ITicketWith ticketWith = (ITicketWith) ticket;
			final IDateTicket date = ticketWith.getDateTicket();
			final boolean result = datesTicket.contains(date);
			
			if(result) {
				LOG.info("Le ticket ayant pour date "+ date.toString()+" est reconnue par le système informatique");
				lecteurBancaire.demandeInsertionCarte(result);

			}
			else {
				LOG.info("Le ticket ayant pour date "+ date.toString()+" n'est pas reconnue par le système informatique");
			} 
			lecteur.restitutionTicket(result);
			return result;
		}
		else {
			throw new TicketErreur("Aucun ticket n'a ete insere !");
		}
	}

	@Override
	public int calculPrix(IDateTicket date) {
		LOG.info("Calcul du prix en fonction de la durée de stationnement ...");
		return (dateDuJour.getHeure()-date.getHeure())+(dateDuJour.getJour()-date.getJour())*24;
	}

	
}