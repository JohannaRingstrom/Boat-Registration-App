package model.boattypes;

import model.Boat;

/**
 * A subclass of Boat.
 */
public class Sailboat extends Boat {

  private int depth;

  /**
   * The Sailboat extension of Boat.

   * @param name name of the boat.
   * @param length in metres.
   * @param depth in metres.
   */
  public Sailboat(String name, int length, int depth) {
    super(name, length);
    
    this.depth = depth;
  }

  public void setDepth(int depth) {
    this.depth = depth;
  }

  public int getDepth() {
    return this.depth;
  }

  /**
   * Returns string with details of the boat.
   */
  @Override
  public String getCharacteristics() {
    return "sailboat:" + this.getLength() + ":" + this.getLength() + ":" + this.getDepth();
  }
  
}
