package panneau;

public class PanneauAffichage {
	protected final static int NBPLACES = 400;
	protected static int ENTRES;
	protected static int SORTIS;
	
	public static int getENTRES() {
		return ENTRES;
	}

	public static void setENTRES(int eNTRES) {
		ENTRES = eNTRES;
	}

	public static int getSORTIS() {
		return SORTIS;
	}

	public static void setSORTIS(int sORTIS) {
		SORTIS = sORTIS;
	}

	

	public static int getNombrePlacesLibres() {
		return PanneauAffichage.NBPLACES-(PanneauAffichage.ENTRES-PanneauAffichage.SORTIS);
	}
}
