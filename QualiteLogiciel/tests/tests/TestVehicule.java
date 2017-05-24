package tests;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import vehicule.impl.CategorieVehicule;
import vehicule.impl.Vehicule;
import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Class TestVehicule.
 */
@RunWith(Parameterized.class)
public class TestVehicule {


    /** The vehicule. */
    private IVehicule vehicule;
    
    /** The categorie. */
    private CategorieVehicule categorie;
    
    /**
     * Instantiates a new test vehicule.
     *
     * @param vehicule the vehicule
     * @param categorie the categorie
     */
    public TestVehicule(IVehicule vehicule, CategorieVehicule categorie) {
        this.vehicule = vehicule;
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
        	{new Vehicule(CategorieVehicule.VOITURE, 0), CategorieVehicule.VOITURE}, 
        	{new Vehicule(CategorieVehicule.CAMION, 0), CategorieVehicule.CAMION},
        	{new Vehicule(CategorieVehicule.CAMIONETTE, 0), CategorieVehicule.CAMIONETTE},
        	{new Vehicule(CategorieVehicule.MOTO, 0), CategorieVehicule.MOTO}};
        return Arrays.asList(data);
    }
	
    /**
     * Modification immatriculation.
     */
    @Test
	public void modificationImmatriculation() {
		this.vehicule.setImmatriculation(123456788);
		Assert.assertEquals(123456788, this.vehicule.getImmatriculation());
	}
    
    /**
     * Verfication categorie.
     */
    @Test
	public void verficationCategorie() {
    	Assert.assertEquals(this.categorie, this.vehicule.getCategorie());
	}


	
}
