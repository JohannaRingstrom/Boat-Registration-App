package model.boattypes;

import model.Boat;

public class Motorsailer extends Boat{

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

  public Motorsailer(String name, int length, int enginePower) {
    super(name, length);
    this.enginePower = enginePower;
  }

  @Override
  public String getCharacteristics() {
    return this.getLength() + ":" + this.getDepth() + ":" + this.getEnginePower();
  }
  
}
