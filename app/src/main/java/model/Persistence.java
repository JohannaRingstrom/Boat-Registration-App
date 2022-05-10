package model;

/**
 * Prepared class for persistance implementation.
 */
public interface Persistence {
  public void saveData();
  public String stringifyData();
  public void readData();
  public void renderData();
}
