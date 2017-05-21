package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import banque.impl.Banque;
import banque.inter.IBanque;
import cartes.impl.CarteBancaire;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import clients.impl.ClientNonAbonne;
import clients.inter.IClientNonAbonne;
import date.impl.DateTicket;
import erreurs.CarteAbonnementErreur;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.impl.LecteurBancaire;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.impl.LecteurTicket;
import lecteurs.ticket.inter.ILecteurTicket;
import ticket.impl.TicketWith;
import ticket.impl.TicketWithout;
import ticket.inter.IAbstractTicket;
import vehicule.impl.CategorieVehicule;
import vehicule.impl.Vehicule;
import vehicule.inter.IVehicule;

public class TestClientNonAbonne {

private IClientNonAbonne client;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	
	@Before
	public void instanciation() {
				
				//Carte Bancaire et ticket du client
				Integer idCarteBancaire = 1337;
				IAbstractCarte cbClient = new CarteBancaire(idCarteBancaire);

				//Véhicule du client
				Integer immatriculationGrosHummer = 420;

				IVehicule grosHummer = new Vehicule(CategorieVehicule.CAMION, immatriculationGrosHummer);

				//Banque du client
				IBanque banqueClient = new Banque();
				
				//Client
				ClientNonAbonne client = new ClientNonAbonne(grosHummer,cbClient, banqueClient);
				this.client = client;
	}
	
	@Test
	public void insereTicket() throws CarteAbonnementErreur, TicketErreur {

		IAbstractTicket ticketClient = new TicketWith(new DateTicket(02,04, 16, 30, 30)); //entré dans le parking le 2 mai
		client.setTicket(ticketClient);

		ILecteurTicket lecteur = new LecteurTicket();
		client.insereTicket(lecteur);
		Assert.assertEquals(TicketWithout.instance(), client.getTicket());
	}
	
	@Test
	public void insereCarteBancaire() throws CarteAbonnementErreur, TicketErreur, CarteBancaireErreur {
		Integer idCarteBancaire = 1337;
		IAbstractCarte cbClient = new CarteBancaire(idCarteBancaire);
		client.setCarteBancaire(cbClient);
		ILecteurBancaire lecteur = new LecteurBancaire();
		client.insereCarteBancaire(lecteur);
		Assert.assertEquals(CarteWithout.instance(), client.getCarteBancaire());
	}
	
	
	@Test
	public void recupereTicket() throws TicketErreur {

		IAbstractTicket ticketClient = new TicketWith(new DateTicket(02,04, 16, 30, 30)); //entré dans le parking le 2 mai
		client.setTicket(ticketClient);

		ILecteurTicket lecteur = new LecteurTicket();
		lecteur.setTicketClient(ticketClient);
		client.recupereTicket(lecteur);
		Assert.assertEquals(ticketClient, client.getTicket());
	}
	
	@Test
	public void recupereCarteBancaire() throws CarteBancaireErreur {
		Integer idCarteBancaire = 1337;
		IAbstractCarte cbClient = new CarteBancaire(idCarteBancaire);
		client.setCarteBancaire(CarteWithout.instance());
		ILecteurBancaire lecteur = new LecteurBancaire();
		lecteur.setCarteBancaire(cbClient);
		client.recupereCarteBancaire(lecteur);
		Assert.assertEquals(cbClient, client.getCarteBancaire());
	}
	
	
	
	@Test
	public void estAbonne() {
		Assert.assertEquals(false, client.isAbonne());
	}
	
	@Test
	public void sePlaceDevantBarriere() {
		Assert.assertEquals("Le client se positionne devant la barrière", client.sePlaceDevantBarriere());
	}
	
	@Test
	public void passe() {
		Assert.assertEquals("Le client passe", client.passe());
	}

	@Test
	public void erreurTicket() throws TicketErreur {
		expectedEx.expect(TicketErreur.class);
		String message = "Le client n'a pas de ticket.";
	    expectedEx.expectMessage(message);
	    
		ILecteurTicket lecteur = new LecteurTicket();
		client.setTicket(TicketWithout.instance());
		client.insereTicket(lecteur);
	}
	
	@Test
	public void erreurCarteBancaire() throws CarteBancaireErreur {
		expectedEx.expect(CarteBancaireErreur.class);
		String message = "Le client n'a pas de carte bancaire.";
	    expectedEx.expectMessage(message);
	    
		ILecteurBancaire lecteur = new LecteurBancaire();
		client.setCarteBancaire(CarteWithout.instance());
		client.insereCarteBancaire(lecteur);
	}

}
