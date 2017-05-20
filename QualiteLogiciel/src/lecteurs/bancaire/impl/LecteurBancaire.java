package lecteurs.bancaire.impl;

import java.util.logging.Logger;

import banque.impl.Banque;
import banque.inter.IBanque;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import cartes.inter.ICarteBancaire;
import clients.impl.ClientAbonne;
import date.inter.IDateTicket;
import erreurs.BanqueErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import systemeinfo.inter.ISystemeInformatique;
import ticket.impl.TicketWith;

public class LecteurBancaire implements ILecteurBancaire {
	public LecteurBancaire() {
		this.carteBancaireClient = CarteWithout.instance();
		this.banque = new Banque();
	}
	private IAbstractCarte carteBancaireClient;

	/** The logger. */
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

	private IBanque banque;
	public boolean demandeInsertionCarte(final boolean ticketOk) {
		if (ticketOk) {
			LOG.info("Le lecteur de carte bancaire demande l'insertion d'une carte bancaire");
		}
		else {
			LOG.warning("Appel à l'écran du lecteur de carte bancaire sans que le ticket ne soit valide au prealable.");
		}
		return ticketOk;
	}


	public boolean contacterBanque(ICarteBancaire carte, int prix) {
		LOG.info("Le lecteur contacte la banque pour un montant de "+ prix + " euros. C'est cher.");	
		
		return banque.realisePaiement(carte, prix);
	}

	public boolean restitutionCarteBancaire(final boolean retour){
		if(retour) {
			LOG.info("Un message s'affiche : \"OK\" sur l'écran du lecteur de carte bancaire et la carte sort" );
		} else {
			LOG.info("Un message s'affiche : \"Carte erronée\" sur l'écran du lecteur de carte bancaire et la carte sort" );
		}
		return retour;
	}

	public IAbstractCarte getCarteBancaireClient() {
		return carteBancaireClient;
	}

	public void setCarteBancaireClient(IAbstractCarte carteClient) {
		this.carteBancaireClient = carteClient;
	}
	
	public void setBanque(IBanque banque){
		this.banque=banque;
	}


	@Override
	public boolean realiseTransaction(final ISystemeInformatique sys, final ILecteurTicket lecteurTicket) throws TicketErreur, BanqueErreur {
		if(lecteurTicket.getTicketClient().isWith()) {
			IDateTicket date = ((TicketWith) lecteurTicket.getTicketClient()).getDateTicket();
			final int prix = sys.calculPrix(date);
			boolean transaction = this.contacterBanque((ICarteBancaire) this.getCarteBancaireClient(), prix);
			if (transaction) {
				this.restitutionCarteBancaire(transaction);
				return transaction;
			} else {
				throw new BanqueErreur("La transaction n'a pas pu être effectuée");
			}

		} else {
			throw new TicketErreur("Pas de ticket dans le lecteur de ticket.");
		}
	}


}