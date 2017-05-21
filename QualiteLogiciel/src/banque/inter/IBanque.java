/*
 * 
 */
package banque.inter;

import java.util.Set;

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
	
	/**
	 * Gets the ids.
	 *
	 * @return the ids
	 */
	public Set<Integer> getIds();

	/**
	 * Sets the ids.
	 *
	 * @param ids the new ids
	 */
	public void setIds(final Set<Integer> ids);
}
