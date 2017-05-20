package banque.inter;

import cartes.inter.ICarteBancaire;

public interface IBanque {
	
	boolean realisePaiement(ICarteBancaire carte, int prix);
	
	void refusPaiement();
	
	void paiementAutorise();
	
	

}
