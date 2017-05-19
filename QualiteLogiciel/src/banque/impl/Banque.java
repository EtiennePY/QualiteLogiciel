package banque.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import banque.inter.IBanque;
import cartes.inter.ICarteBancaire;
import clients.impl.ClientAbonne;

public class Banque implements IBanque {
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
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
	
	public boolean realisePaiement(ICarteBancaire carte, int prix) {
		LOG.info("La banque effectue le paiement.");
		return true;
	}
	
	public void refusPaiement() {
		
	}
	
	public void paiementAutorise() {
		
	}
	
}
