package banque.impl;

import java.util.HashSet;
import java.util.Set;

import banque.inter.IBanque;
import cartes.inter.ICarteBancaire;

// TODO: Auto-generated Javadoc
/**
 * The Class Banque.
 */
public class MockBanque implements IBanque {
	

	/** The ids. */
	private Set<Integer> ids;

	/**
	 * Instantiates a new banque.
	 */
	public MockBanque() {
		this.ids = new HashSet<Integer>();
	}
	
	/**
	 * Gets the ids.
	 *
	 * @return the ids
	 */
	public Set<Integer> getIds() {
		return ids;
	}

	/**
	 * Sets the ids.
	 *
	 * @param ids the new ids
	 */
	public void setIds(final Set<Integer> ids) {
		this.ids = ids;
	}
	
	/**
	 * Realise paiement.
	 *
	 * @param carte the carte
	 * @param prix the prix
	 * @return true, if successful
	 */
	public boolean realisePaiement(final ICarteBancaire carte, final int prix) { 
		return true;
	}
	
}
