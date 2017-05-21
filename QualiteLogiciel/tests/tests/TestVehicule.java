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

@RunWith(Parameterized.class)
public class TestVehicule {


    private IVehicule vehicule;
    private CategorieVehicule categorie;
    public TestVehicule(IVehicule vehicule, CategorieVehicule categorie) {
        this.vehicule = vehicule;
        this.categorie = categorie;
    }

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
	
    @Test
	public void modificationImmatriculation() {
		this.vehicule.setImmatriculation(123456788);
		Assert.assertEquals(123456788, this.vehicule.getImmatriculation());
	}
    
    @Test
	public void verficationCategorie() {
    	Assert.assertEquals(this.categorie, this.vehicule.getCategorie());
	}


	
}
