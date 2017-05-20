package erreurs;

public class BanqueErreur extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BanqueErreur (String message) {
		super(message);
	}

}
