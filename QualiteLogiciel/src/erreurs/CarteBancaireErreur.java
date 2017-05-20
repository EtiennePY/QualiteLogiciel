package erreurs;

public class CarteBancaireErreur extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarteBancaireErreur (String message) {
		super(message);
	}

}
