package lecteur;

import banque.Banque;
import carte.Carte;
import carte.CarteWithout;
import client.ClientNonAbonne;

public class LecteurBancaire{
	public LecteurBancaire() {
		this.carteBancaireClient = CarteWithout.instance();
		this.banque = new Banque();
	}
	private Carte carteBancaireClient;
	private Banque banque;
	public void demandeInsertionCarte(Carte carte) {
		System.out.println("Le lecteur demande l'insertion de la carte bancaire");
	}
	
	
	public boolean contacterBanque(int prix) {
		System.out.println("Le lecteur contacte la banque pour un montant de "+ prix);	
		return false;
	}
	
	public Carte restitutionCarteBancaire(boolean ok, ClientNonAbonne client){
		Carte res = this.getCarteBancaireClient();
		this.setCarteBancaireClient(CarteWithout.instance());
		System.out.println("Le lecteur de carte bancaire restitue la carte");
		return res;
}

	public Carte getCarteBancaireClient() {
		return carteBancaireClient;
	}

	public void setCarteBancaireClient(Carte carteClient) {
		this.carteBancaireClient = carteClient;
	}
}