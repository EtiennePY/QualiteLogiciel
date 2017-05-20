/*
 * 
 */
package banque.inter;

import cartes.inter.ICarteBancaire;

// TODO: Auto-generated Javadoc
/**
 * The Interface IBanque.
 */
public interface IBanque {
	
	/**
	 * Realise paiement.
	 *
	 * @param carte the carte
	 * @param prix the prix
	 * @return true, if successful
	 */
	boolean realisePaiement(ICarteBancaire carte, int prix);
	
	
}
