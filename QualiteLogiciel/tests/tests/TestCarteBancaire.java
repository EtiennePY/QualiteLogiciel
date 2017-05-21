package tests;

import org.junit.Assert;
import org.junit.Test;

import cartes.impl.CarteBancaire;
import cartes.inter.ICarteBancaire;

public class TestCarteBancaire {

	@Test
	public void instanciation() {
		ICarteBancaire carte = new CarteBancaire(123456789);
		Assert.assertEquals(123456789, carte.getIdentifiant());
	}

}
