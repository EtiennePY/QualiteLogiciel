package cartes.impl;

import cartes.inter.IAbstractCarteWith;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractCarteWith.
 */
public abstract class AbstractCarteWith extends AbstractCarte implements IAbstractCarteWith {
  
  /** The identifiant. */
  private final int identifiant;
  
  /**
   * Instantiates a new abstract carte.
   *
   * @param identifiant the identifiant
   */
  public AbstractCarteWith(final int identifiant) {
    super();
    this.identifiant = identifiant;
  }

  /**
   * Gets the identifiant.
   *
   * @return the identifiant
   */
  public int getIdentifiant() {
    return identifiant;
  }

  
}
