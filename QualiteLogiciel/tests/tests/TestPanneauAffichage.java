package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import panneau.impl.PanneauAffichage;
import panneau.inter.IPanneauAffichage;

public class TestPanneauAffichage {

	private IPanneauAffichage panneau;

	@Before
	public void instanciationPanneau() {
		this.panneau = new PanneauAffichage();
	}
	
	@Test
	public void moinsUneVoiture() {
		int nombreDePlacesAvant = panneau.getNombrePlacesLibres();
		panneau.minus();
		int nombreDePlacesApres = panneau.getNombrePlacesLibres();

		Assert.assertEquals(nombreDePlacesAvant, nombreDePlacesApres - 1);
	}
	
	@Test
	public void plusUneVoiture() {
		int nombreDePlacesAvant = panneau.getNombrePlacesLibres();
		panneau.add();
		int nombreDePlacesApres = panneau.getNombrePlacesLibres();

		Assert.assertEquals(nombreDePlacesAvant, nombreDePlacesApres + 1);
	}
	
	
}
