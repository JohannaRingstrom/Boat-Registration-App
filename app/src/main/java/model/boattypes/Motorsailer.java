package model.boattypes;

public class Motorsailer extends Motorboat{

  private int depth;

  public int getDepth() {
    return depth;
  }

  public void setDepth(int depth) {
    this.depth = depth;
  }

  public Motorsailer(int length, int enginePower) {
    super(length, enginePower);
  }
  
}
