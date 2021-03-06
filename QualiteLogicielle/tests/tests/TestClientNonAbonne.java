package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import banque.impl.MockBanque;
import banque.inter.IBanque;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import clients.impl.ClientNonAbonne;
import clients.inter.IClientNonAbonne;
import date.impl.DateTicket;
import erreurs.CarteAbonnementErreur;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import mocks.cartes.MockCarteBancaire;
import mocks.lecteurs.MockLecteurBancaire;
import mocks.lecteurs.MockLecteurTicket;
import mocks.ticket.MockTicketWith;
import mocks.vehicule.MockVehicule;
import ticket.impl.TicketWithout;
import ticket.inter.IAbstractTicket;
import vehicule.impl.CategorieVehicule;
import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Class TestClientNonAbonne.
 */
public class TestClientNonAbonne {

/** The client. */
private IClientNonAbonne client;
	
	/** The expected ex. */
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	
	/**
	 * Instanciation.
	 */
	@Before
	public void instanciation() {
				
				//Carte Bancaire et ticket du client
				Integer idCarteBancaire = 1337;
				IAbstractCarte cbClient = new MockCarteBancaire(idCarteBancaire);

				//V�hicule du client
				Integer immatriculationGrosHummer = 420;

				IVehicule grosHummer = new MockVehicule(CategorieVehicule.CAMION, immatriculationGrosHummer);

				//Banque du client
				IBanque banqueClient = new MockBanque();
				
				//Client
				IClientNonAbonne client = new ClientNonAbonne(grosHummer,cbClient, banqueClient);
				this.client = client;
	}
	
	/**
	 * Settergetterbanque.
	 */
	@Test
	public void settergetterbanque() {

		IBanque banque = new MockBanque();
		client.setBanque(banque);
		Assert.assertEquals(client.getBanque(), banque);
	}

	/**
	 * Insere ticket.
	 *
	 * @throws CarteAbonnementErreur the carte abonnement erreur
	 * @throws TicketErreur the ticket erreur
	 */
	@Test
	public void insereTicket() throws CarteAbonnementErreur, TicketErreur {

		IAbstractTicket ticketClient = new MockTicketWith(new DateTicket(02,04, 16, 30, 30)); //entr� dans le parking le 2 mai
		client.setTicket(ticketClient);

		ILecteurTicket lecteur = new MockLecteurTicket();
		client.insereTicket(lecteur);
		Assert.assertEquals(TicketWithout.instance(), client.getTicket());
	}
	
	/**
	 * Insere carte bancaire.
	 *
	 * @throws CarteAbonnementErreur the carte abonnement erreur
	 * @throws TicketErreur the ticket erreur
	 * @throws CarteBancaireErreur the carte bancaire erreur
	 */
	@Test
	public void insereCarteBancaire() throws CarteAbonnementErreur, TicketErreur, CarteBancaireErreur {
		Integer idCarteBancaire = 1337;
		IAbstractCarte cbClient = new MockCarteBancaire(idCarteBancaire);
		client.setCarteBancaire(cbClient);
		ILecteurBancaire lecteur = new MockLecteurBancaire();
		client.insereCarteBancaire(lecteur);
		Assert.assertEquals(CarteWithout.instance(), client.getCarteBancaire());
	}
	
	
	/**
	 * Recupere ticket.
	 *
	 * @throws TicketErreur the ticket erreur
	 */
	@Test
	public void recupereTicket() throws TicketErreur {

		IAbstractTicket ticketClient = new MockTicketWith(new DateTicket(02,04, 16, 30, 30)); //entr� dans le parking le 2 mai
		client.setTicket(ticketClient);

		ILecteurTicket lecteur = new MockLecteurTicket();
		lecteur.setTicketClient(ticketClient);
		client.recupereTicket(lecteur);
		Assert.assertEquals(ticketClient, client.getTicket());
	}
	
	/**
	 * Recupere carte bancaire.
	 *
	 * @throws CarteBancaireErreur the carte bancaire erreur
	 */
	@Test
	public void recupereCarteBancaire() throws CarteBancaireErreur {
		Integer idCarteBancaire = 1337;
		IAbstractCarte cbClient = new MockCarteBancaire(idCarteBancaire);
		client.setCarteBancaire(CarteWithout.instance());
		ILecteurBancaire lecteur = new MockLecteurBancaire();
		lecteur.setCarteBancaire(cbClient);
		client.recupereCarteBancaire(lecteur);
		Assert.assertEquals(cbClient, client.getCarteBancaire());
	}
	
	
	
	/**
	 * Est abonne.
	 */
	@Test
	public void estAbonne() {
		Assert.assertEquals(false, client.isAbonne());
	}
	
	/**
	 * Se place devant barriere.
	 */
	@Test
	public void sePlaceDevantBarriere() {
		Assert.assertEquals("Le client se positionne devant la barri�re", client.sePlaceDevantBarriere());
	}
	
	/**
	 * Passe.
	 */
	@Test
	public void passe() {
		Assert.assertEquals("Le client passe", client.passe());
	}

	/**
	 * Erreur ticket.
	 *
	 * @throws TicketErreur the ticket erreur
	 */
	@Test
	public void erreurTicket() throws TicketErreur {
		expectedEx.expect(TicketErreur.class);
		String message = "Le client n'a pas de ticket.";
	    expectedEx.expectMessage(message);
	    
		ILecteurTicket lecteur = new MockLecteurTicket();
		client.setTicket(TicketWithout.instance());
		client.insereTicket(lecteur);
	}
	
	/**
	 * Erreur carte bancaire.
	 *
	 * @throws CarteBancaireErreur the carte bancaire erreur
	 */
	@Test
	public void erreurCarteBancaire() throws CarteBancaireErreur {
		expectedEx.expect(CarteBancaireErreur.class);
		String message = "Le client n'a pas de carte bancaire.";
	    expectedEx.expectMessage(message);
	    
		ILecteurBancaire lecteur = new MockLecteurBancaire();
		client.setCarteBancaire(CarteWithout.instance());
		client.insereCarteBancaire(lecteur);
	}

}
