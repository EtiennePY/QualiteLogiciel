package cartes.impl;

import cartes.inter.ICarteBancaire;

/**
 * The Class CarteBancaire.
 */
public class CarteBancaire extends AbstractCarteWith implements ICarteBancaire {
  
  /**
   * Instantiates a new carte bancaire.
   *
   * @param identifiant the identifiant
   */
  public CarteBancaire(final int identifiant) {
    super(identifiant);
  }
}
