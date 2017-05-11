package cartes.inter;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICarteWithout.
 */
public interface ICarteWithout extends IAbstractCarte {
	
	/* (non-Javadoc)
	 * @see carte.IAbstractCarte#isWith()
	 */
	boolean isWith();
	
	//instance() est static donc pas dans l'interface (faiblesse de Java pour la maintenance)
}
