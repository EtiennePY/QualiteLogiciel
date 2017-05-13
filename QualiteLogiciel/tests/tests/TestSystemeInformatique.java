package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import abonnement.Abonnement;
import barriere.impl.BarriereSortie;
import barriere.inter.IBarriereSortie;
import cartes.impl.CarteAbonnement;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import cartes.inter.ICarteAbonnement;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import lecteurs.abonnement.impl.LecteurCarteAbonnement;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import systemeinfo.impl.SystemeInformatique;
import systemeinfo.inter.ISystemeInformatique;
import vehicule.impl.CategorieVehicule;
import vehicule.impl.Vehicule;
import vehicule.inter.IVehicule;

public class TestSystemeInformatique {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	
	private ISystemeInformatique sys;
	
	@Before
	public void instanciation() {
		this.sys = new SystemeInformatique();
	}
	
	@Test
	public void enregistrementClientAbonne() {
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
		sys.enregistreClientAbonne(immatriculationClient, idClient, abonnement);
		Assert.assertEquals(true, sys.getAbonnements().containsKey(immatriculationClient));
		Assert.assertEquals(true, sys.getImmatriculations().containsKey(idClient));
	}
	
	@Test
	public void checkAbonnementAvecCarteValide() throws CarteAbonnementErreur, BarriereErreur {
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new CarteAbonnement(idClient, abonnement);
				
		//On definit les véhicules qu'il possède
		List<IVehicule> vehicules = new ArrayList<IVehicule>();
		IVehicule voiturette = new Vehicule(CategorieVehicule.VOITURE, immatriculationClient);
		vehicules.add(voiturette);
		

		
		//On cree le lecteur de carte d'abonnement
		ILecteurCarteAbonnement lecteurAbo = new LecteurCarteAbonnement();
		
		IBarriereSortie barriere = new BarriereSortie();

		sys.enregistreClientAbonne(immatriculationClient, idClient, abonnement);
		Assert.assertEquals(true, sys.checkAbonnement(carteAbonnement, lecteurAbo, barriere));
	}

	@Test
	public void checkAbonnementAvecCarteInvalide() throws CarteAbonnementErreur, BarriereErreur {
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
		sys.enregistreClientAbonne(immatriculationClient, idClient, abonnement);

		Integer idErronee = 68;

		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new CarteAbonnement(idErronee, abonnement);
				
		//On definit les véhicules qu'il possède
		List<IVehicule> vehicules = new ArrayList<IVehicule>();
		IVehicule voiturette = new Vehicule(CategorieVehicule.VOITURE, immatriculationClient);
		vehicules.add(voiturette);
		

		
		//On cree le lecteur de carte d'abonnement
		ILecteurCarteAbonnement lecteurAbo = new LecteurCarteAbonnement();
		
		IBarriereSortie barriere = new BarriereSortie();

		Assert.assertEquals(false, sys.checkAbonnement(carteAbonnement, lecteurAbo, barriere));
	}

	@Test
	public void checkAbonnementSansCarte() throws CarteAbonnementErreur, BarriereErreur {
		
		expectedEx.expect(CarteAbonnementErreur.class);
		String message = "Aucune carte d'abonnement n'a ete inseree !";
	    expectedEx.expectMessage(message);
		
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
		sys.enregistreClientAbonne(immatriculationClient, idClient, abonnement);

	

		//On definit sa carte d'abonnement
		IAbstractCarte carteAbonnement = CarteWithout.instance();
				
		//On definit les véhicules qu'il possède
		List<IVehicule> vehicules = new ArrayList<IVehicule>();
		IVehicule voiturette = new Vehicule(CategorieVehicule.VOITURE, immatriculationClient);
		vehicules.add(voiturette);
		

		
		//On cree le lecteur de carte d'abonnement
		ILecteurCarteAbonnement lecteurAbo = new LecteurCarteAbonnement();
		
		IBarriereSortie barriere = new BarriereSortie();

		sys.checkAbonnement(carteAbonnement, lecteurAbo, barriere);
	}
}
