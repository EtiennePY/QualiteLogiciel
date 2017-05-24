package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The Class AllTests.
 */
@RunWith(Suite.class)
@SuiteClasses({ TestTicket.class,
    TestDateTicket.class, 
    TestMockBanque.class, 
    TestAbonnement.class, 
    TestBarriereSortie.class, 
    TestCarteAbonnement.class, 
    TestCarteBancaire.class, 
    TestCategorieVehicule.class, 
    TestClientAbonne.class, 
    TestDetecteurSortie.class, 
    TestLecteurAbonnement.class, 
    TestLecteurBancaire.class, 
    TestLecteurTicket.class, 
    TestClientNonAbonne.class, 
    TestPanneauAffichage.class, 
    TestSystemeInformatique.class, 
    TestVehicule.class 
  })
public class AllTests {

}
