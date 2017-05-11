package systemeInformatique.impl;

import java.util.HashMap;
import java.util.logging.Logger;

import abonnement.Abonnement;
import barriere.inter.IBarriereSortie;
import cartes.impl.AbstractCarte;
import cartes.impl.AbstractCarteWith;
import clients.impl.ClientAbonne;
import erreurs.CarteInsereeErreur;
import lecteurCarteAbonnement.impl.LecteurCarteAbonnement;
import systemeInformatique.inter.ISystemeInformatique;
import ticket.impl.Ticket;

public class SystemeInformatique implements ISystemeInformatique {
	/** The logger. */
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

	//a partir de l'immatriculation trouver l'abonnement
	private HashMap<Integer, Abonnement> abonnements;


	//a partir de l'id trouver l'immatriculation
	protected HashMap<Integer, Integer> identifiants;

	public SystemeInformatique() {
		this.abonnements = new HashMap<Integer, Abonnement>();
		this.identifiants = new HashMap<Integer, Integer>();

	}
	public HashMap<Integer, Abonnement> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(HashMap<Integer, Abonnement> abonnements) {
		this.abonnements = abonnements;
	}

	public HashMap<Integer, Integer> getIds() {
		return identifiants;
	}

	public void setIds(HashMap<Integer, Integer> ids) {
		this.identifiants = identifiants;
	}


	public boolean checkAbonnement(AbstractCarte carte, LecteurCarteAbonnement lecteur) throws CarteInsereeErreur{
		if(carte.isWith()){
			boolean result = identifiants.containsKey((((AbstractCarteWith) carte).getIdentifiant()));

			if(result) {
				this.carteAbonnementValide((AbstractCarteWith) carte);
			}
			else {
				this.mauvaiseCarteAbonnement(carte);
			}
			lecteur.restitutionCarte(result);
			return result;

		} else {
			throw new CarteInsereeErreur();
		}
	}


	public void enregistrerDateHeure() {
		// TODO Auto-generated method stub
	}


	public int calcuPrix() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int donnePrixAPayer(int prix) {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean mauvaiseCarteAbonnement(AbstractCarte carte) throws CarteInsereeErreur {
		if(carte.isWith()){
			LOG.info("La carte ayant pour id "+((AbstractCarteWith) carte).getIdentifiant()+" n'est pas reconnue par le système informatique");
			return false;
		} else {
			throw new CarteInsereeErreur();
		}
	}


	public boolean carteAbonnementValide(AbstractCarteWith carte) {
		LOG.info("La carte ayant pour id "+carte.getIdentifiant()+" est reconnue par le système informatique");
		return true;
	}


	public boolean ticketNonValide(Ticket ticket) {
		// TODO Auto-generated method stub
		return false;
	}


	public void changeAbonnement(int identifiant, Abonnement abonnement) {
		// TODO Auto-generated method stub

	}


	public void ouvreBarriere(IBarriereSortie barriere) {
		LOG.info("Le système informatique provoque l'ouverture de la barrière");
		barriere.ouvrir();    

	}


	public boolean checkTicket(Ticket ticket, LecteurCarteAbonnement lecteur) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean ticketValide(Ticket ticket) {
		// TODO Auto-generated method stub
		return false;
	}
}