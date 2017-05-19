package banque.inter;

import cartes.inter.ICarteBancaire;

public interface IBanque {
	
	public boolean realisePaiement(ICarteBancaire carte, int prix);
	
	public void refusPaiement();
	
	public void paiementAutorise();
	
	

}
