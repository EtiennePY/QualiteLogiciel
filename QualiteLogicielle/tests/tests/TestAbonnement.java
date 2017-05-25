package tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import abonnement.Abonnement;

@RunWith(Parameterized.class)
public class TestAbonnement {


    private Abonnement abonnement;
    public TestAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { 
          {Abonnement.OCCASIONNEL}, 
          {Abonnement.PROFESSIONNEL},
          {Abonnement.REGULIER}};
        return Arrays.asList(data);
    }
    
    @Test
    public void valuesOf() {
      Abonnement.valueOf(this.abonnement.toString());
    }
    
 

}
