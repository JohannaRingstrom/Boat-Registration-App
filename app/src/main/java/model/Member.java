package model;

import java.util.ArrayList;


/**
 * Class representing a member of the boat club.
 */
public class Member {
  private String name;
  private String email;
  private String id;
  private ArrayList<Boat> fleet;


  /**
   * Constructor for the Member class.

   * @param name The name of the member.
   * @param email The email of the member.
   * @param id Unique ID for the boat club.
   */
  public Member(String name, String email, String id) {
    this.name = name;
    this.email = email;
    this.id = id;
    this.fleet = new ArrayList<Boat>();
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getEmail() {
    return email;
  }


  public void setPersonalNumber(String email) {
    
    this.email = email;
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

  public void addBoat(Boat boat) {
    this.fleet.add(boat);
  }
  
}
