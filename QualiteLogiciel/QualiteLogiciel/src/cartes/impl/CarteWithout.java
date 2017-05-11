/*
 * 
 */
package cartes.impl;

import cartes.inter.IAbstractCarte;

// TODO: Auto-generated Javadoc
/**
 * The Class CarteWithout.
 */
public class CarteWithout extends AbstractCarte implements IAbstractCarte {
	
	/** The Constant CARTEWITHOUT. */
	private final static CarteWithout SINGLETON = new CarteWithout();
	
	/**
	 * Instance.
	 *
	 * @return the carte without
	 */
	public static CarteWithout instance() {
		return CarteWithout.SINGLETON;
	}
	
	/**
	 * Checks if is with.
	 *
	 * @return true, if is with
	 */
	public boolean isWith(){
		return false;
	}
	

}
