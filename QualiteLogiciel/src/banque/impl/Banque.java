package banque.impl;

import java.util.HashSet;
import java.util.Set;

import banque.inter.IBanque;
import cartes.impl.CarteBancaire;

public class Banque implements IBanque {
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
	
	public boolean realisePaiement(CarteBancaire carte, int prix) {
		return true;
	}
	
	public void refusPaiement() {
		
	}
	
	public void paiementAutorise() {
		
	}
	
}
