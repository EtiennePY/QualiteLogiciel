package date.impl;

import date.inter.IDateTicket;

// TODO: Auto-generated Javadoc
/**
 * The Class Date.
 */
public class DateTicket implements IDateTicket {
  
  /** The mois. */
  private int mois;
  
  /** The jour. */
  private int jour;
  
  /** The heure. */
  private int heure;
  
  /** The minute. */
  private int minute;
  
  /** The seconde. */
  private int seconde;
  
  /**
   * Instantiates a new date.
   *
   * @param jour the jour
   * @param heure the heure
   */
  public DateTicket(final int jour, final int mois, final int heure, final int minute, final int seconde){
    this.jour = jour;
    this.heure = heure;
    this.minute = minute;
    this.seconde = seconde;
    this.mois = mois;
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
  
  /**
   * Gets the minute.
   *
   * @return the minute
   */
  public int getMinute() {
    return minute;
  }
  
  /**
   * Sets the minute.
   *
   * @param minute the new minute
   */
  public void setMinute(final int minute) {
    this.minute = minute;
  }
  
  /**
   * Gets the seconde.
   *
   * @return the seconde
   */
  public int getSeconde() {
    return seconde;
  }
  
  /**
   * Sets the seconde.
   *
   * @param seconde the new seconde
   */
  public void setSeconde(final int seconde) {
    this.seconde = seconde;
  }
  
  /**
   * Gets the mois.
   *
   * @return the mois
   */
  public int getMois() {
    return mois;
  }
  
  /**
   * Sets the mois.
   *
   * @param mois the new mois
   */
  public void setMois(final int mois) {
    this.mois = mois;
  }
}
