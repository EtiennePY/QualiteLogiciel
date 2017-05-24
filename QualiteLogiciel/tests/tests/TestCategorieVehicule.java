package tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import vehicule.impl.CategorieVehicule;
// TODO: Auto-generated Javadoc

/**
 * The Class TestCategorieVehicule.
 */
@RunWith(Parameterized.class)
public class TestCategorieVehicule {


    /** The categorie. */
    private CategorieVehicule categorie;
    
    /**
     * Instantiates a new test categorie vehicule.
     *
     * @param categorie the categorie
     */
    public TestCategorieVehicule(CategorieVehicule categorie) {
        this.categorie = categorie;
    }

    /**
     * Data.
     *
     * @return the collection
     */
    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { 
        	{CategorieVehicule.VOITURE}, 
        	{CategorieVehicule.CAMION},
        	{CategorieVehicule.CAMIONETTE},
        	{CategorieVehicule.MOTO}};
        return Arrays.asList(data);
    }
    
    /**
     * Verification values.
     */
    @Test
   	public void verificationValues() {
    	CategorieVehicule.valueOf(this.categorie.toString());
    }

}
