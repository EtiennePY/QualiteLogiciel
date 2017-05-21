package mocks.cartes;

import cartes.inter.ICarteBancaire;

/**
 * The Class CarteBancaire.
 */
public class MockCarteBancaire extends MockAbstractCarteWith implements ICarteBancaire {
	
	/**
	 * Instantiates a new carte bancaire.
	 *
	 * @param identifiant the identifiant
	 */
	public MockCarteBancaire(final int identifiant){
		super(identifiant);
	}
}
