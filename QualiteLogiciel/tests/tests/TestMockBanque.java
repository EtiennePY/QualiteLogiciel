package tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import banque.impl.MockBanque;
import banque.inter.IBanque;
import cartes.inter.ICarteBancaire;
import mocks.cartes.MockCarteBancaire;

public class TestMockBanque {

	private IBanque banque;
	
	@Before
	public void instanciation() {
		this.banque = new MockBanque();
	}
	
	@Test
	public void getterSetterIds() {
		Set<Integer> ids = new HashSet<Integer>();
		banque.setIds(ids);
		Assert.assertEquals(ids, banque.getIds());
	}
	
	@Test
	public void realiseTransaction() {
		ICarteBancaire carte = new MockCarteBancaire(123456789);
		int prix = 420;
		Assert.assertEquals(true, banque.realisePaiement(carte, prix));
	}
}
