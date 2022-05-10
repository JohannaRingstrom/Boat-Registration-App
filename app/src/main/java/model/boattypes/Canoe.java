package model.boattypes;

import model.Boat;

public class Canoe extends Boat{

  public Canoe(String name, int length) {
    super(name, length);
  }

  @Override
  public String getCharacteristics() {
    return Integer.toString(this.getLength());
  }
  
}
