package model;

import java.util.ArrayList;


/**
 * Class representing a member of the boat club.
 */
public class Member {
  private String name;
  private long personalNumber;
  private String id;
  private ArrayList<Boat> fleet;


  /**
   * Constructor for the Member class.

   * @param name The name of the member.
   * @param personalNumber The personal number (social security number) of the member.
   * @param id Unique ID for the boat club.
   */
  public Member(String name, long personalNumber, String id) {
    this.name = name;
    this.personalNumber = personalNumber;
    this.id = id;
    this.fleet = new ArrayList<Boat>();
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public long getPersonalNumber() {
    return personalNumber;
  }


  public void setPersonalNumber(long personalNumber) {
    this.personalNumber = personalNumber;
  }


  public String getId() {
    return id;
  }


  public Boat getBoatByIndex(int index) {
    return fleet.get(index);
  }

  public Iterable<Boat> getFleet() {
    return new ArrayList<Boat>(fleet);
  }

  public int getFleetLength() {
    return fleet.size();
  }
 

  public void addBoat(BoatType bt, int length) {
    Boat b = new Boat(bt, length);
    this.fleet.add(b);
  }
  
}
