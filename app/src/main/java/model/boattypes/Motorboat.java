package model.boattypes;

import model.Boat;

public class Motorboat extends Boat {

  private int enginePower;

  public int getEnginePower() {
    return enginePower;
  }

  public void setEnginePower(int enginePower) {
    this.enginePower = enginePower;
  }

  public Motorboat(int length, int enginePower) {
    super(length);
    
    this.enginePower = enginePower;
  }

}
