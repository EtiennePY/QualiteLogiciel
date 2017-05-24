package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import panneau.impl.PanneauAffichage;
import panneau.inter.IPanneauAffichage;

// TODO: Auto-generated Javadoc
/**
 * The Class TestPanneauAffichage.
 */
public class TestPanneauAffichage {

	/** The panneau. */
	private IPanneauAffichage panneau;

	/**
	 * Instanciation panneau.
	 */
	@Before
	public void instanciationPanneau() {
		this.panneau = new PanneauAffichage();
	}
	
	/**
	 * Moins une voiture.
	 */
	@Test
	public void moinsUneVoiture() {
		int nombreDePlacesAvant = panneau.getNombrePlacesLibres();
		panneau.minus();
		int nombreDePlacesApres = panneau.getNombrePlacesLibres();

		Assert.assertEquals(nombreDePlacesAvant, nombreDePlacesApres - 1);
	}
	
	/**
	 * Plus une voiture.
	 */
	@Test
	public void plusUneVoiture() {
		int nombreDePlacesAvant = panneau.getNombrePlacesLibres();
		panneau.add();
		int nombreDePlacesApres = panneau.getNombrePlacesLibres();

		Assert.assertEquals(nombreDePlacesAvant, nombreDePlacesApres + 1);
	}
	
	
}
