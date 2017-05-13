package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBarriereSortie.class, TestCarteAbonnement.class, TestCategorieVehicule.class, TestDetecteurSortie.class, TestLecteurAbonnement.class, TestPanneauAffichage.class, TestVehicule.class })
public class AllTests {

}
