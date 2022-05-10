package model.boattypes;

import model.Boat;

/**
 * A subclass of Boat.
 */
public class Canoe extends Boat {

  public Canoe(String name, int length) {
    super(name, length);
  }

  /**
   * Returns string with details of the boat.
   */
  @Override
  public String getCharacteristics() {
    return "canoe:" + this.getLength();
  }
  
}
