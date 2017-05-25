package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import abonnement.Abonnement;
import cartes.impl.CarteAbonnement;
import cartes.inter.ICarteAbonnement;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCarteAbonnement.
 */
public class TestCarteAbonnement {

	/** The carte abonnement regulier. */
	private ICarteAbonnement carteAbonnementRegulier;
	
	/** The carte abonnement occasionnel. */
	private ICarteAbonnement carteAbonnementOccasionnel;
	
	/** The carte abonnement professionnel. */
	private ICarteAbonnement carteAbonnementProfessionnel;
	
	/**
	 * Instanciation.
	 */
	@Before
	public void instanciation() {
		this.carteAbonnementRegulier = new CarteAbonnement(1, Abonnement.REGULIER);
		this.carteAbonnementOccasionnel = new CarteAbonnement(1, Abonnement.OCCASIONNEL);
		this.carteAbonnementProfessionnel = new CarteAbonnement(1, Abonnement.PROFESSIONNEL);
	}
	
	/**
	 * Gets the ter abonnement.
	 *
	 * @return the ter abonnement
	 */
	@Test
	public void getterAbonnement() {
		Assert.assertEquals(this.carteAbonnementRegulier.getAbonnement(),Abonnement.REGULIER);
		Assert.assertEquals(this.carteAbonnementOccasionnel.getAbonnement(),Abonnement.OCCASIONNEL);
		Assert.assertEquals(this.carteAbonnementProfessionnel.getAbonnement(),Abonnement.PROFESSIONNEL);
	}
	
	/**
	 * Setter abonnement.
	 */
	@Test
	public void setterAbonnement() {
		this.carteAbonnementRegulier.setAbonnement(Abonnement.OCCASIONNEL);
		Assert.assertEquals(this.carteAbonnementRegulier.getAbonnement(),Abonnement.OCCASIONNEL);
		
	}
	
	/**
	 * Est bienune carte.
	 */
	@Test
	public void estBienuneCarte() {
		Assert.assertEquals(this.carteAbonnementRegulier.isWith(),true);
	}
	
	
}
