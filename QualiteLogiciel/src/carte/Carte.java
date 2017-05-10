package carte;

/**
 * The Class Carte.
 */
public abstract class Carte {
	
	protected int identifiant;

	public int getIdentifiant() {
		return identifiant;
	}

	public void setId(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public boolean isWithout() {
		return false;
	}
}
