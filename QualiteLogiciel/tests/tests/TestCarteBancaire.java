package tests;

import org.junit.Assert;
import org.junit.Test;

import cartes.impl.CarteBancaire;
import cartes.inter.ICarteBancaire;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCarteBancaire.
 */
public class TestCarteBancaire {

	/**
	 * Instanciation.
	 */
	@Test
	public void instanciation() {
		ICarteBancaire carte = new CarteBancaire(123456789);
		Assert.assertEquals(123456789, carte.getIdentifiant());
	}

}
