package tests;

import org.junit.Test;

import erreurs.BanqueErreur;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import main.MainAbonne;
import main.MainNonAbonne;

public class TestMains {

	@Test
	public void test() throws CarteAbonnementErreur, BarriereErreur, TicketErreur, CarteBancaireErreur, BanqueErreur {
	MainAbonne.main(new String[] {"arg1", "arg2", "arg3"});
	MainNonAbonne.main(new String[] {"arg1", "arg2", "arg3"});

	}

}
