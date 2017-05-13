package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import barriere.impl.BarriereSortie;
import barriere.inter.IBarriereSortie;
import erreurs.BarriereErreur;

public class TestBarriereSortie {

	private IBarriereSortie barriere;
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void instanciationBarriere() {
		this.barriere = new BarriereSortie();
	}
	
	@Test
	public void fermeInitialement() {
		Assert.assertEquals(false, barriere.isOuverte());
	}
	
	@Test
	public void setter() {
		barriere.setOuverte(true);
		Assert.assertEquals(true, barriere.isOuverte());
		barriere.setOuverte(false);
		Assert.assertEquals(false, barriere.isOuverte());
	}
	
	@Test
	public void ouvrirAvecBarriereFermee() throws BarriereErreur {
		barriere.ouvrir();
		Assert.assertEquals(true, barriere.isOuverte());
	}
	
	@Test
	public void fermerAvecBarriereOuverte() throws BarriereErreur {
		barriere.ouvrir();
		barriere.fermer();
		Assert.assertEquals(false, barriere.isOuverte());
	}
	
	@Test
	public void fermerAvecBarriereFermee() throws BarriereErreur {
		expectedEx.expect(BarriereErreur.class);
		String message = "La barriere est deja fermee !";
	    expectedEx.expectMessage(message);
	    
		barriere.fermer();
	}
	
	@Test
	public void ouvrirAvecBarriereOuverte() throws BarriereErreur {
		expectedEx.expect(BarriereErreur.class);
		String message = "La barriere est deja ouverte !";
	    expectedEx.expectMessage(message);
		barriere.ouvrir();
		barriere.ouvrir();
	}
	
}
