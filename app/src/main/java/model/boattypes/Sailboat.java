package model.boattypes;

import model.Boat;

public class Sailboat extends Boat{

  private int depth;

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

  @Override
  public String getCharacteristics() {
    return this.getLength() + ":" + this.getLength() + ":" + this.getDepth();
  }
  
}
