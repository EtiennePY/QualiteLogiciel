package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import abonnement.Abonnement;
import cartes.impl.CarteAbonnement;
import cartes.inter.ICarteAbonnement;

public class TestCarteAbonnement {

	private ICarteAbonnement carteAbonnementRegulier;
	private ICarteAbonnement carteAbonnementOccasionnel;
	private ICarteAbonnement carteAbonnementProfessionnel;
	@Before
	public void instanciation() {
		this.carteAbonnementRegulier = new CarteAbonnement(1, Abonnement.REGULIER);
		this.carteAbonnementOccasionnel = new CarteAbonnement(1, Abonnement.OCCASIONNEL);
		this.carteAbonnementProfessionnel = new CarteAbonnement(1, Abonnement.PROFESSIONNEL);
	}
	
	@Test
	public void getterAbonnement() {
		Assert.assertEquals(this.carteAbonnementRegulier.getAbonnement(),Abonnement.REGULIER);
		Assert.assertEquals(this.carteAbonnementOccasionnel.getAbonnement(),Abonnement.OCCASIONNEL);
		Assert.assertEquals(this.carteAbonnementProfessionnel.getAbonnement(),Abonnement.PROFESSIONNEL);
	}
	
	@Test
	public void setterAbonnement() {
		this.carteAbonnementRegulier.setAbonnement(Abonnement.OCCASIONNEL);
		Assert.assertEquals(this.carteAbonnementRegulier.getAbonnement(),Abonnement.OCCASIONNEL);
		
	}
	@Test
	public void estBienuneCarte() {
		Assert.assertEquals(this.carteAbonnementRegulier.isWith(),true);
	}

}
