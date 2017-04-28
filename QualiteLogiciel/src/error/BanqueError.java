package error;

public class BanqueError extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BanqueError() {
		super("La transaction ne s'est pas déroulée correctement.");
	}

}
