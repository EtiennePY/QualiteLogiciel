package carte;

// TODO: Auto-generated Javadoc
/**
 * The Class Carte.
 */
public abstract class AbstractCarte implements IAbstractCarte {
	
	/** The identifiant. */
	protected int identifiant;

	/**
	 * Gets the identifiant.
	 *
	 * @return the identifiant
	 */
	public int getIdentifiant() {
		return identifiant;
	}

	/**
	 * Sets the id.
	 *
	 * @param identifiant the new id
	 */
	public void setId(final int identifiant) {
		this.identifiant = identifiant;
	}
	
	/**
	 * Checks if is without.
	 *
	 * @return true, if is without
	 */
	public boolean isWithout() {
		return false;
	}
}
