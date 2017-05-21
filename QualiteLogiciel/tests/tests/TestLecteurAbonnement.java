package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import abonnement.Abonnement;
import barriere.inter.IBarriereSortie;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import cartes.inter.ICarteAbonnement;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import lecteurs.abonnement.impl.LecteurCarteAbonnement;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import mocks.barriere.MockBarriereSortie;
import mocks.cartes.MockCarteAbonnement;
import mocks.systemeinfo.MockSystemeInformatique;
import systemeinfo.inter.ISystemeInformatique;

public class TestLecteurAbonnement {
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	private ILecteurCarteAbonnement lecteurAbo;
	@Before 
	public void instanciationLecteur() {
		this.lecteurAbo = new LecteurCarteAbonnement();
	}
	
	@Test
	public void instanciationCorrecte() {
		Assert.assertEquals(CarteWithout.instance(), this.lecteurAbo.getCarteClient());
	}
	
	@Test
	public void demandeInsertionCorrecte() {
		Assert.assertEquals(true, this.lecteurAbo.demandeInsertionCarte(true));
	}
	@Test
	public void demandeInsertionIncorrecte() {
		Assert.assertEquals(false, this.lecteurAbo.demandeInsertionCarte(false));
	}
	
	@Test
	public void restitutionSansProblemes() {
		Assert.assertEquals(true, this.lecteurAbo.restitutionCarte(true));
	}
	
	@Test
	public void restitutionAvecProblemes() {
		Assert.assertEquals(false, this.lecteurAbo.restitutionCarte(false));
	}
	
	@Test
	public void checkAbonnementCorrect() throws CarteAbonnementErreur, BarriereErreur {
		//On definit ici l'identifiant du client, son immatriculation, et son abonnement.
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
				
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new MockCarteAbonnement(idClient, abonnement);
		this.lecteurAbo.setCarteClient(carteAbonnement);
		ISystemeInformatique sys = new MockSystemeInformatique();
		IBarriereSortie barriere = new MockBarriereSortie(); 
		sys.enregistreClientAbonne(immatriculationClient, idClient, abonnement);
			
		Assert.assertEquals(true, this.lecteurAbo.checkAbonnement(sys, barriere));
	}
	
	@Test
	public void checkAbonnementIncorrect() throws CarteAbonnementErreur, BarriereErreur {
		//On definit ici l'identifiant du client, son immatriculation, et son abonnement.
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
				
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new MockCarteAbonnement(idClient, abonnement);
		this.lecteurAbo.setCarteClient(carteAbonnement);
		ISystemeInformatique sys = new MockSystemeInformatique();
		IBarriereSortie barriere = new MockBarriereSortie(); 
		sys.enregistreClientAbonne(immatriculationClient, 2, abonnement);
			
		Assert.assertEquals(false, this.lecteurAbo.checkAbonnement(sys, barriere));
	}
	
	@Test
	public void checkAbonnementSansCarte() throws CarteAbonnementErreur, BarriereErreur {
		expectedEx.expect(CarteAbonnementErreur.class);
		String message = "Aucune carte d'abonnement n'a ete inseree !";
	    expectedEx.expectMessage(message);
	    
		//On definit ici l'identifiant du client, son immatriculation, et son abonnement.
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
				
		//On definit sa carte d'abonnement
		IAbstractCarte carteAbonnement = CarteWithout.instance();
		this.lecteurAbo.setCarteClient(carteAbonnement);
		ISystemeInformatique sys = new MockSystemeInformatique();
		IBarriereSortie barriere = new MockBarriereSortie(); 
		sys.enregistreClientAbonne(immatriculationClient, idClient, abonnement);
			
		this.lecteurAbo.checkAbonnement(sys, barriere);
	}
}
