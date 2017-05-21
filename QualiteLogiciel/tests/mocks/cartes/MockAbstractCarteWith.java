package mocks.cartes;

import cartes.inter.IAbstractCarteWith;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractCarteWith.
 */
public abstract class MockAbstractCarteWith extends MockAbstractCarte implements IAbstractCarteWith {
	
	/** The identifiant. */
	final protected int identifiant;
	
	/**
	 * Instantiates a new abstract carte.
	 *
	 * @param identifiant the identifiant
	 */
	public MockAbstractCarteWith(final int identifiant) {
		super();
		this.identifiant = identifiant;
	}

	/**
	 * Gets the identifiant.
	 *
	 * @return the identifiant
	 */
	public int getIdentifiant() {
		return identifiant;
	}

	
}
