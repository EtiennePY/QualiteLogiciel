package lecteurs.bancaire.impl;

import java.util.logging.Logger;

import banque.impl.Banque;
import banque.inter.IBanque;
import cartes.impl.AbstractCarte;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import clients.impl.ClientAbonne;
import clients.impl.ClientNonAbonne;
import lecteurs.bancaire.inter.ILecteurBancaire;

public class LecteurBancaire implements ILecteurBancaire {
	public LecteurBancaire() {
		this.carteBancaireClient = CarteWithout.instance();
		this.banque = new Banque();
	}
	private IAbstractCarte carteBancaireClient;

	/** The logger. */
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

	private IBanque banque;
	public void demandeInsertionCarte(IAbstractCarte carte) {
		LOG.info("Le lecteur demande l'insertion de la carte bancaire");
	}


	public boolean contacterBanque(int prix) {
		LOG.info("Le lecteur contacte la banque pour un montant de "+ prix+" euros. C'est cher.");	
		return false;
	}

	public IAbstractCarte restitutionCarteBancaire(boolean ok, ClientNonAbonne client){
		IAbstractCarte res = this.getCarteBancaireClient();
		this.setCarteBancaireClient(CarteWithout.instance());
		LOG.info("Le lecteur de carte bancaire restitue la carte");
		return res;
	}

	public IAbstractCarte getCarteBancaireClient() {
		return carteBancaireClient;
	}

	public void setCarteBancaireClient(AbstractCarte carteClient) {
		this.carteBancaireClient = carteClient;
	}
	
	public void setBanque(IBanque banque){
		this.banque=banque;
	}
}