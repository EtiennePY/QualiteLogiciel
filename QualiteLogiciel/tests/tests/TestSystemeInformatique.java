package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import abonnement.Abonnement;
import banque.impl.MockBanque;
import banque.inter.IBanque;
import barriere.inter.IBarriereSortie;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import cartes.inter.ICarteAbonnement;
import clients.inter.IClientNonAbonne;
import date.impl.DateTicket;
import date.inter.IDateTicket;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import erreurs.TicketErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import mocks.barriere.MockBarriereSortie;
import mocks.cartes.MockCarteAbonnement;
import mocks.cartes.MockCarteBancaire;
import mocks.clients.MockClientNonAbonne;
import mocks.lecteurs.MockLecteurBancaire;
import mocks.lecteurs.MockLecteurCarteAbonnement;
import mocks.lecteurs.MockLecteurTicket;
import mocks.ticket.MockTicketWith;
import mocks.vehicule.MockVehicule;
import systemeinfo.impl.SystemeInformatique;
import systemeinfo.inter.ISystemeInformatique;
import ticket.impl.TicketWithout;
import ticket.inter.IAbstractTicket;
import ticket.inter.ITicketWith;
import vehicule.impl.CategorieVehicule;
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
	public void getterSetterDateDuJour() {
		IDateTicket date = new DateTicket(17, 4, 16, 30, 30);
		sys.setDateDuJour(date);
		Assert.assertEquals(date, sys.getDateDuJour());
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
		ICarteAbonnement carteAbonnement = new MockCarteAbonnement(idClient, abonnement);
				
		//On definit les véhicules qu'il possède
		List<IVehicule> vehicules = new ArrayList<IVehicule>();
		IVehicule voiturette = new MockVehicule(CategorieVehicule.VOITURE, immatriculationClient);
		vehicules.add(voiturette);
		

		
		//On cree le lecteur de carte d'abonnement
		ILecteurCarteAbonnement lecteurAbo = new MockLecteurCarteAbonnement();
		
		IBarriereSortie barriere = new MockBarriereSortie();

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
		ICarteAbonnement carteAbonnement = new MockCarteAbonnement(idErronee, abonnement);
				
		//On definit les véhicules qu'il possède
		List<IVehicule> vehicules = new ArrayList<IVehicule>();
		IVehicule voiturette = new MockVehicule(CategorieVehicule.VOITURE, immatriculationClient);
		vehicules.add(voiturette);
		

		
		//On cree le lecteur de carte d'abonnement
		ILecteurCarteAbonnement lecteurAbo = new MockLecteurCarteAbonnement();
		
		IBarriereSortie barriere = new MockBarriereSortie();

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
		IVehicule voiturette = new MockVehicule(CategorieVehicule.VOITURE, immatriculationClient);
		vehicules.add(voiturette);
		

		
		//On cree le lecteur de carte d'abonnement
		ILecteurCarteAbonnement lecteurAbo = new MockLecteurCarteAbonnement();
		
		IBarriereSortie barriere = new MockBarriereSortie();

		sys.checkAbonnement(carteAbonnement, lecteurAbo, barriere);
	}

	@Test
	public void calculPrix() {
		sys.setDateDuJour(new DateTicket(17, 04, 17, 30, 30));
		IDateTicket date = new DateTicket(16, 04, 16, 30, 30);
		Assert.assertEquals(24 + 1, sys.calculPrix(date));
	}
	

	@Test
	public void checkTicketAvecTicketValide() throws TicketErreur, BarriereErreur {

		//Nous sommes le 16 mai
		IDateTicket dateDuJour = new DateTicket(16,04, 16, 30, 30);
		
		//Carte Bancaire et ticket du client
		Integer idCarteBancaire = 1337;
		IAbstractCarte cbClient = new MockCarteBancaire(idCarteBancaire);
		IAbstractTicket ticketClient = new MockTicketWith(new DateTicket(02,04, 16, 30, 30)); //entré dans le parking le 2 mai

		//Véhicule du client
		Integer immatriculationGrosHummer = 420;

		IVehicule grosHummer = new MockVehicule(CategorieVehicule.CAMION, immatriculationGrosHummer);

		//Banque du client
		IBanque banqueClient = new MockBanque();
		
		//Client
		IClientNonAbonne etienne = new MockClientNonAbonne(grosHummer,cbClient, banqueClient);
		etienne.setTicket(ticketClient);



		//On cree les lecteurs de carte bancaire et de ticket
		ILecteurBancaire lecteurBancaire = new MockLecteurBancaire();
		ILecteurTicket lecteurTicket = new MockLecteurTicket();


		//On cree le systeme informatique
		sys.enregistreClientNonAbonne(((ITicketWith)ticketClient).getDateTicket());
		sys.setDateDuJour(dateDuJour);
		//On cree le panneau d'affichage et la barriere
		
		Assert.assertEquals(true, sys.checkTicket(etienne.getTicket(), lecteurTicket, lecteurBancaire));
	}
	
	@Test
	public void checkTicketAvecTicketInvalide() throws TicketErreur, BarriereErreur {

		
		//Nous sommes le 16 mai
		IDateTicket dateDuJour = new DateTicket(17,04, 16, 30, 30);
		
		//Carte Bancaire et ticket du client
		Integer idCarteBancaire = 1337;
		IAbstractCarte cbClient = new MockCarteBancaire(idCarteBancaire);
		IAbstractTicket ticketClient = new MockTicketWith(new DateTicket(02,04, 16, 30, 30)); //entré dans le parking le 2 mai

		//Véhicule du client
		Integer immatriculationGrosHummer = 420;

		IVehicule grosHummer = new MockVehicule(CategorieVehicule.CAMION, immatriculationGrosHummer);

		//Banque du client
		IBanque banqueClient = new MockBanque();
		
		//Client
		IClientNonAbonne etienne = new MockClientNonAbonne(grosHummer,cbClient, banqueClient);
		etienne.setTicket(new MockTicketWith(new DateTicket(16, 04, 16, 30, 30)));



		//On cree les lecteurs de carte bancaire et de ticket
		ILecteurBancaire lecteurBancaire = new MockLecteurBancaire();
		ILecteurTicket lecteurTicket = new MockLecteurTicket();


		//On cree le systeme informatique
		sys.enregistreClientNonAbonne(((ITicketWith)ticketClient).getDateTicket());
		sys.setDateDuJour(dateDuJour);
		//On cree le panneau d'affichage et la barriere
		
		Assert.assertEquals(false, sys.checkTicket(etienne.getTicket(), lecteurTicket, lecteurBancaire));
	}
	
	@Test
	public void checkTicketSansTicket() throws TicketErreur, BarriereErreur {

		expectedEx.expect(TicketErreur.class);
		String message = "Aucun ticket n'a ete insere !";
	    expectedEx.expectMessage(message);
		
		//Nous sommes le 16 mai
		IDateTicket dateDuJour = new DateTicket(17,04, 16, 30, 30);
		
		//Carte Bancaire et ticket du client
		Integer idCarteBancaire = 1337;
		IAbstractCarte cbClient = new MockCarteBancaire(idCarteBancaire);
		IAbstractTicket ticketClient = new MockTicketWith(new DateTicket(02,04, 16, 30, 30)); //entré dans le parking le 2 mai

		//Véhicule du client
		Integer immatriculationGrosHummer = 420;

		IVehicule grosHummer = new MockVehicule(CategorieVehicule.CAMION, immatriculationGrosHummer);

		//Banque du client
		IBanque banqueClient = new MockBanque();
		
		//Client
		IClientNonAbonne etienne = new MockClientNonAbonne(grosHummer,cbClient, banqueClient);
		etienne.setTicket(TicketWithout.instance());



		//On cree les lecteurs de carte bancaire et de ticket
		ILecteurBancaire lecteurBancaire = new MockLecteurBancaire();
		ILecteurTicket lecteurTicket = new MockLecteurTicket();


		//On cree le systeme informatique
		sys.enregistreClientNonAbonne(((ITicketWith)ticketClient).getDateTicket());
		sys.setDateDuJour(dateDuJour);
		
		sys.checkTicket(etienne.getTicket(), lecteurTicket, lecteurBancaire);
	}


}
