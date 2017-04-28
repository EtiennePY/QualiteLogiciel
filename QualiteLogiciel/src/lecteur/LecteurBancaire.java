package lecteur;

import carte.Carte;
import carte.CarteBancaire;
import carte.CarteWithout;

public class LecteurBancaire {
	public LecteurBancaire() {
		this.carteBancaireClient = CarteWithout.instance();
	}
	private Carte carteBancaireClient;
	public void demandeInsertionCarteBancaire(CarteBancaire carte) {
		System.out.println("Le lecteur demande l'insertion de la carte bancaire");
	}
	
	public void contacterBanque(CarteBancaire carte, int prix) {
		System.out.println("Le lecteur contacte la banque pour la carte " + carte.toString() + ", pour un montant de "+ prix);	
	}
	
	public Carte restitutionCarteBancaire(){
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