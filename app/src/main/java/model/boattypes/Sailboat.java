package model.boattypes;

import model.Boat;

public class Sailboat extends Boat{

  private int depth;

  public Sailboat(int length, int depth) {
    super(length);
    
    this.depth = depth;
  }

  public void setDepth(int depth) {
    this.depth = depth;
  }

  public int getDepth() {
    return this.depth;
  }
  
}
