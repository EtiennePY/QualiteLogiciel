package banque;

import java.util.List;

import carte.CarteBancaire;

public class Banque {
	protected List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	public boolean realisePaiement(CarteBancaire carte, int prix) {
		return false;
		
	}
	
	public void refusPaiement() {
		
	}
	
	public void paiementAutorise() {
		
	}
	
}
