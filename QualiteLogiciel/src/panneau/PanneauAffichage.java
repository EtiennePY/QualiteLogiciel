package panneau;

public class PanneauAffichage {
	protected final static int NBPLACES = 400;

	protected static int ENTRES;
	protected static int SORTIS;

	public static int getNombrePlacesLibres() {
		return PanneauAffichage.NBPLACES-(PanneauAffichage.ENTRES-PanneauAffichage.SORTIS);
	}
}
