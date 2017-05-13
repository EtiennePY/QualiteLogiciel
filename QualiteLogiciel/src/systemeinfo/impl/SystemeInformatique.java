/*
 * 
 */
package systemeinfo.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import abonnement.Abonnement;
import barriere.inter.IBarriereSortie;
import cartes.impl.AbstractCarteWith;
import cartes.inter.IAbstractCarte;
import cartes.inter.IAbstractCarteWith;
import clients.impl.ClientAbonne;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import lecteurs.abonnement.impl.LecteurCarteAbonnement;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import systemeinfo.inter.ISystemeInformatique;
import ticket.impl.Ticket;

public class SystemeInformatique implements ISystemeInformatique {
	/** The logger. */
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

	//a partir de l'immatriculation trouver l'abonnement
	private Map<Integer, Abonnement> abonnements;


	//a partir de l'id trouver l'immatriculation
	protected Map<Integer, Integer> identifiants;

	public SystemeInformatique() {
		this.abonnements = new HashMap<Integer, Abonnement>();
		this.identifiants = new HashMap<Integer, Integer>();

	}
	public Map<Integer, Abonnement> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(final Map<Integer, Abonnement> abonnements) {
		this.abonnements = abonnements;
	}

	public Map<Integer, Integer> getIdentifiants() {
		return identifiants;
	}

	public void setIdentifiants(final Map<Integer, Integer> ids) {
		this.identifiants = identifiants;
	}
	public void enregistreClientAbonne(Integer immatriculation, Integer id, Abonnement abonnement) {
		this.getIdentifiants().put(id, immatriculation);
		this.getAbonnements().put(immatriculation, abonnement);
	}
	public boolean checkAbonnement(final IAbstractCarte carte, final ILecteurCarteAbonnement lecteur, final IBarriereSortie barriere) throws CarteAbonnementErreur, BarriereErreur {
		if(carte.isWith()){
			final IAbstractCarteWith carteWith = (AbstractCarteWith) carte;
			final Integer identifiant = carteWith.getIdentifiant();
			final boolean result = identifiants.containsKey(identifiant);
			
			if(result) {
				LOG.info("La carte ayant pour id "+ identifiants+" est reconnue par le système informatique");
				this.ouvreBarriere(barriere);

			}
			else {
				LOG.info("La carte ayant pour id "+identifiant+" n'est pas reconnue par le système informatique");
			} 
			lecteur.restitutionCarte(result);
			return result;
		}
		else {
			throw new CarteAbonnementErreur("Aucune carte d'abonnement n'a ete inseree !");
		}
	}

	public void enregistrerDateHeure() {
		// TODO Auto-generated method stub
	}

	public int calcuPrix() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int donnePrixAPayer(final int prix) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean ticketNonValide(final Ticket ticket) {
		// TODO Auto-generated method stub
		return false;
	}

	public void ouvreBarriere(final IBarriereSortie barriere) throws BarriereErreur {
		LOG.info("Le système informatique provoque l'ouverture de la barrière");
		barriere.ouvrir();    

	}

	public boolean checkTicket(final Ticket ticket, final LecteurCarteAbonnement lecteur) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ticketValide(final Ticket ticket) {
		// TODO Auto-generated method stub
		return false;
	}
}