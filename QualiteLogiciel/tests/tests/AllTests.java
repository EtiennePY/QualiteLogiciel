package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAbonnement.class, TestBarriereSortie.class, TestCarteAbonnement.class, TestCarteBancaire.class, TestCategorieVehicule.class, TestClientAbonne.class, TestDetecteurSortie.class, TestLecteurAbonnement.class, TestLecteurBancaire.class, TestLecteurTicket.class, TestMains.class, TestClientNonAbonne.class, TestPanneauAffichage.class, TestSystemeInformatique.class, TestVehicule.class })
public class AllTests {

}
