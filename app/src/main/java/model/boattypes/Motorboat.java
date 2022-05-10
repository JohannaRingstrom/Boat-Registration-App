package model.boattypes;

import model.Boat;

/**
 * A subclass of Boat.
 */
public class Motorboat extends Boat {

  private int enginePower;

  public int getEnginePower() {
    return enginePower;
  }

  public void setEnginePower(int enginePower) {
    this.enginePower = enginePower;
  }

  /**
   * The motorboat extension of Boat.

   * @param name name of the boat.
   * @param length in metres.
   * @param enginePower in horse powers.
   */
  public Motorboat(String name, int length, int enginePower) {
    super(name, length);
    
    this.enginePower = enginePower;
  }

  /**
   * Returns string with details of the boat.
   */
  @Override
  public String getCharacteristics() {
    return "motorsailer:" + this.getLength() + ":" + this.getEnginePower();
  }

}
