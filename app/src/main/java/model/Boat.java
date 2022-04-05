package model;

/**
 * A class representing a boat.
 */
public abstract class Boat {
  
  private int length;

  public Boat(int length) {
    this.length = length;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  
}
