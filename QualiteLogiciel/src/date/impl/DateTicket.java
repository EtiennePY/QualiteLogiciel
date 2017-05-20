package date.impl;

import date.inter.IDateTicket;

// TODO: Auto-generated Javadoc
/**
 * The Class Date.
 */
public class DateTicket implements IDateTicket {
	
	/** The jour. */
	protected int jour;
	
	/** The heure. */
	protected int heure;
	
	/**
	 * Instantiates a new date.
	 *
	 * @param jour the jour
	 * @param heure the heure
	 */
	public DateTicket(final int jour, final int heure){
		this.jour=jour;
		this.heure=heure;
	}
	
	/**
	 * Gets the jour.
	 *
	 * @return the jour
	 */
	public int getJour() {
		return jour;
	}
	
	/**
	 * Sets the jour.
	 *
	 * @param jour the new jour
	 */
	public void setJour(final int jour) {
		this.jour = jour;
	}
	
	/**
	 * Gets the heure.
	 *
	 * @return the heure
	 */
	public int getHeure() {
		return heure;
	}
	
	/**
	 * Sets the heure.
	 *
	 * @param heure the new heure
	 */
	public void setHeure(final int heure) {
		this.heure = heure;
	}
}
