package model.boattypes;

import model.Boat;

/**
 * A subclass of Boat.
 */
public class Motorsailer extends Boat {

  private int depth;
  private int enginePower;

  public int getEnginePower() {
    return enginePower;
  }

  public void setEnginePower(int enginePower) {
    this.enginePower = enginePower;
  }

  public int getDepth() {
    return depth;
  }

  public void setDepth(int depth) {
    this.depth = depth;
  }

  /**
   * The motorsailer extention of Boat.

   * @param name name of the boat.
   * @param length in metres.
   * @param depth in metres.
   * @param enginePower in horse powers.
   */
  public Motorsailer(String name, int length, int depth, int enginePower) {
    super(name, length);
    this.enginePower = enginePower;
    this.depth = depth;
  }

  /**
   * Returns string with details of the boat.
   */
  @Override
  public String getCharacteristics() {
    return "motorsailer:" + this.getLength() + ":" + this.getDepth() + ":" + this.getEnginePower();
  }
  
}
