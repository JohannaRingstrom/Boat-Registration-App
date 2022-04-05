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

  public Motorboat(String name, int length, int enginePower) {
    super(name, length);
    
    this.enginePower = enginePower;
  }

}
