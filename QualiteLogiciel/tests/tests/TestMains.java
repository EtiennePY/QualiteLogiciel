package tests;

import org.junit.Test;

import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import main.MainAbonneOk;
import main.MainNonAbonneOk;

public class TestMains {

	@Test
	public void test() throws CarteAbonnementErreur, BarriereErreur, TicketErreur, CarteBancaireErreur {
	MainAbonneOk.main(new String[] {"arg1", "arg2", "arg3"});
	MainNonAbonneOk.main(new String[] {"arg1", "arg2", "arg3"});

	}

}
