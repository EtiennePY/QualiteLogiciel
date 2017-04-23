package barriere;

public abstract class Barriere {
	protected static boolean ouverte;



	public static boolean isOuverte() {
		return ouverte;
	}

	public static void setOuverte(boolean ouverte) {
		Barriere.ouverte = ouverte;
	}
	
	public static void ouvrir() {
		
	}
	
	public static void fermer() {
		
	}

}
