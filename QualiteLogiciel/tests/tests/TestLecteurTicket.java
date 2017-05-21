package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import date.impl.DateTicket;
import date.inter.IDateTicket;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.impl.LecteurTicket;
import lecteurs.ticket.inter.ILecteurTicket;
import mocks.lecteurs.MockLecteurBancaire;
import mocks.systemeinfo.MockSystemeInformatique;
import mocks.ticket.MockTicketWith;
import systemeinfo.inter.ISystemeInformatique;
import ticket.impl.TicketWithout;
import ticket.inter.IAbstractTicket;

public class TestLecteurTicket {
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	private ILecteurTicket lecteur;
	@Before 
	public void instanciationLecteur() {
		this.lecteur = new LecteurTicket();
	}
	
	@Test
	public void instanciationCorrecte() {
		Assert.assertEquals(TicketWithout.instance(), this.lecteur.getTicketClient());
	}
	
	@Test
	public void demandeInsertionCorrecte() {
		Assert.assertEquals(true, this.lecteur.demandeInsertionTicket(true));
	}
	@Test
	public void demandeInsertionIncorrecte() {
		Assert.assertEquals(false, this.lecteur.demandeInsertionTicket(false));
	}
	
	@Test
	public void restitutionSansProblemes() {
		Assert.assertEquals(true, this.lecteur.restitutionTicket(true));
	}
	
	@Test
	public void restitutionAvecProblemes() {
		Assert.assertEquals(false, this.lecteur.restitutionTicket(false));
	}
	
	@Test
	public void checkDateCorrect() throws TicketErreur {
		ILecteurBancaire lecteurBancaire = new MockLecteurBancaire();		
		//On definit sa carte bancaire
		IDateTicket date = new DateTicket(16, 4, 16, 30, 30);
		IAbstractTicket ticket = new MockTicketWith(date);
		this.lecteur.setTicketClient(ticket);
		ISystemeInformatique sys = new MockSystemeInformatique();
		sys.enregistreClientNonAbonne(date);
		Assert.assertEquals(true, this.lecteur.verificationTicket(sys, lecteurBancaire));
	}
	
	@Test
	public void checkTicketIncorrect() throws TicketErreur, BarriereErreur {
		ILecteurBancaire lecteurBancaire = new MockLecteurBancaire();		
		//On definit sa carte bancaire
		IDateTicket date = new DateTicket(16, 4, 16, 30, 30);
		this.lecteur.setTicketClient(new MockTicketWith(new DateTicket(16, 3, 16, 30, 30)));
		ISystemeInformatique sys = new MockSystemeInformatique();
		sys.enregistreClientNonAbonne(date);
		Assert.assertEquals(false, this.lecteur.verificationTicket(sys, lecteurBancaire));
	}

	@Test
	public void checkSansTicket() throws CarteAbonnementErreur, BarriereErreur, TicketErreur {
		expectedEx.expect(TicketErreur.class);
		String message = "Aucun ticket n'a ete insere !";
	    expectedEx.expectMessage(message);
	    
		ILecteurBancaire lecteurBancaire = new MockLecteurBancaire();		
		//On definit sa carte bancaire
		IDateTicket date = new DateTicket(16, 4, 16, 30, 30);
		this.lecteur.setTicketClient(TicketWithout.instance());
		ISystemeInformatique sys = new MockSystemeInformatique();
		sys.enregistreClientNonAbonne(date);
		this.lecteur.verificationTicket(sys, lecteurBancaire);
	}

}
