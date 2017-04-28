package banque;

import java.util.HashSet;
import java.util.Set;

import carte.CarteBancaire;
import error.BanqueError;

public class Banque {
	protected Set<Integer> ids;

	public Banque() {
		this.ids = new HashSet<Integer>();
	}
	
	public Set<Integer> getIds() {
		return ids;
	}

	public void setIds(Set<Integer> ids) {
		this.ids = ids;
	}
	
	public boolean realisePaiement(CarteBancaire carte, int prix) throws BanqueError {
		return true;
	}
	
	public void refusPaiement() {
		
	}
	
	public void paiementAutorise() {
		
	}
	
}
