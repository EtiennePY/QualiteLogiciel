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
import cartes.inter.ICarteAbonnement;
import clients.impl.ClientAbonne;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import lecteurs.abonnement.impl.LecteurCarteAbonnement;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import systemeinfo.inter.ISystemeInformatique;
import ticket.impl.Ticket;
import ticket.inter.ITicket;

public class SystemeInformatique implements ISystemeInformatique {
	/** The logger. */
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

	//a partir de l'immatriculation trouver l'abonnement
		private final Map<Integer, Abonnement> abonnements;


		//a partir de l'id trouver l'immatriculation
		protected final Map<Integer, Integer> immatriculations;

	public SystemeInformatique() {
		this.abonnements = new HashMap<Integer, Abonnement>();
		this.immatriculations = new HashMap<Integer, Integer>();

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
	public boolean checkAbonnement(final IAbstractCarte carte, final ILecteurCarteAbonnement lecteur, final IBarriereSortie barriere) throws CarteAbonnementErreur, BarriereErreur {
		if(carte.isWith()){
			final IAbstractCarteWith carteWith = (AbstractCarteWith) carte;
			final Integer identifiant = carteWith.getIdentifiant();
			final boolean result = immatriculations.containsKey(identifiant);
			
			if(result) {
				LOG.info("La carte ayant pour id "+ immatriculations+" est reconnue par le système informatique");
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
	@Override
	public boolean checkAbonnement(ICarteAbonnement carte) throws CarteAbonnementErreur {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean mauvaiseCarteAbonnement(ICarteAbonnement carte) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean carteAbonnementValide(ICarteAbonnement carte) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean ticketNonValide(ITicket ticket) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void addId(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteId(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void changeAbonnement(int id, Abonnement abonnement) {
		// TODO Auto-generated method stub
		
	}
}