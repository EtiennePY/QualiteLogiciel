package lecteurBancaire.impl;

import banque.impl.Banque;
import cartes.impl.AbstractCarte;
import cartes.impl.CarteWithout;
import clients.impl.ClientNonAbonne;
import lecteurBancaire.inter.ILecteurBancaire;

public class LecteurBancaire implements ILecteurBancaire {
	public LecteurBancaire() {
		this.carteBancaireClient = CarteWithout.instance();
		this.banque = new Banque();
	}
	private AbstractCarte carteBancaireClient;
	private Banque banque;
	public void demandeInsertionCarte(AbstractCarte carte) {
		System.out.println("Le lecteur demande l'insertion de la carte bancaire");
	}
	
	
	public boolean contacterBanque(int prix) {
		System.out.println("Le lecteur contacte la banque pour un montant de "+ prix);	
		return false;
	}
	
	public AbstractCarte restitutionCarteBancaire(boolean ok, ClientNonAbonne client){
		AbstractCarte res = this.getCarteBancaireClient();
		this.setCarteBancaireClient(CarteWithout.instance());
		System.out.println("Le lecteur de carte bancaire restitue la carte");
		return res;
}

	public AbstractCarte getCarteBancaireClient() {
		return carteBancaireClient;
	}

	public void setCarteBancaireClient(AbstractCarte carteClient) {
		this.carteBancaireClient = carteClient;
	}
}