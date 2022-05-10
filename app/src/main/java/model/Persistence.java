package model;

/**
 * Prepared class for persistance implementation.
 */
public interface Persistence {
  public void saveData();
  public void stringifyData();
  public void readData();
  public void renderData();
}
