/*
 * 
 */
package cartes.impl;

import cartes.inter.ICarteWithout;

// TODO: Auto-generated Javadoc
/**
 * The Class CarteWithout.
 */
public class CarteWithout extends AbstractCarte implements ICarteWithout {
	
	/**
	 * Instantiates a new carte without.
	 */
	public CarteWithout(){
		super();
	}
	
	/** The Constant CARTEWITHOUT. */
	private final static CarteWithout CARTEWITHOUT = new CarteWithout();
	
	/**
	 * Instance.
	 *
	 * @return the carte without
	 */
	public static CarteWithout instance() {
		return CarteWithout.CARTEWITHOUT;
	}
	
	/* (non-Javadoc)
	 * @see carte.AbstractCarte#isWith()
	 */
	public boolean isWith(){
		return false;
	}
	

}
