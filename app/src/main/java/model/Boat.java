package model;

/**
 * A class representing a boat.
 */
public class Boat {
  
  private BoatType type;
  private int length;

  public Boat(BoatType type, int length) {
    this.type = type;
    this.length = length;
  }

  public BoatType getType() {
    return type;
  }

  public void setType(BoatType type) {
    this.type = type;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  
}
