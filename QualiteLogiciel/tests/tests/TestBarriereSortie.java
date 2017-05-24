package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import barriere.impl.BarriereSortie;
import barriere.inter.IBarriereSortie;
import erreurs.BarriereErreur;

// TODO: Auto-generated Javadoc
/**
 * The Class TestBarriereSortie.
 */
public class TestBarriereSortie {

	/** The barriere. */
	private IBarriereSortie barriere;
	
	/** The expected ex. */
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	/**
	 * Instanciation barriere.
	 */
	@Before
	public void instanciationBarriere() {
		this.barriere = new BarriereSortie();
	}
	
	/**
	 * Ferme initialement.
	 */
	@Test
	public void fermeInitialement() {
		Assert.assertEquals(false, barriere.isOuverte());
	}
	
	/**
	 * Setter.
	 */
	@Test
	public void setter() {
		barriere.setOuverte(true);
		Assert.assertEquals(true, barriere.isOuverte());
		barriere.setOuverte(false);
		Assert.assertEquals(false, barriere.isOuverte());
	}
	
	/**
	 * Ouvrir avec barriere fermee.
	 *
	 * @throws BarriereErreur the barriere erreur
	 */
	@Test
	public void ouvrirAvecBarriereFermee() throws BarriereErreur {
		barriere.ouvrir();
		Assert.assertEquals(true, barriere.isOuverte());
	}
	
	/**
	 * Fermer avec barriere ouverte.
	 *
	 * @throws BarriereErreur the barriere erreur
	 */
	@Test
	public void fermerAvecBarriereOuverte() throws BarriereErreur {
		barriere.ouvrir();
		barriere.fermer();
		Assert.assertEquals(false, barriere.isOuverte());
	}
	
	/**
	 * Fermer avec barriere fermee.
	 *
	 * @throws BarriereErreur the barriere erreur
	 */
	@Test
	public void fermerAvecBarriereFermee() throws BarriereErreur {
		expectedEx.expect(BarriereErreur.class);
		String message = "La barriere est deja fermee !";
	    expectedEx.expectMessage(message);
	    
		barriere.fermer();
	}
	
	/**
	 * Ouvrir avec barriere ouverte.
	 *
	 * @throws BarriereErreur the barriere erreur
	 */
	@Test
	public void ouvrirAvecBarriereOuverte() throws BarriereErreur {
		expectedEx.expect(BarriereErreur.class);
		String message = "La barriere est deja ouverte !";
	    expectedEx.expectMessage(message);
		barriere.ouvrir();
		barriere.ouvrir();
	}
	
}
