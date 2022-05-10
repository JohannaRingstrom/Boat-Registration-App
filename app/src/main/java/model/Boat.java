package model;

/**
 * A class representing a boat.
 */
public abstract class Boat {
  
  private int length;
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  abstract public String getCharacteristics();

  public Boat(String name, int length) {
    this.length = length;
    this.name = name;
  }
  
}
