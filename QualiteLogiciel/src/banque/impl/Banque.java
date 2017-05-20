package banque.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import banque.inter.IBanque;
import cartes.inter.ICarteBancaire;
import clients.impl.ClientAbonne;

// TODO: Auto-generated Javadoc
/**
 * The Class Banque.
 */
public class Banque implements IBanque {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
	
	/** The ids. */
	protected Set<Integer> ids;

	/**
	 * Instantiates a new banque.
	 */
	public Banque() {
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
		LOG.info("La banque effectue le paiement.");
		return true;
	}
	
}
