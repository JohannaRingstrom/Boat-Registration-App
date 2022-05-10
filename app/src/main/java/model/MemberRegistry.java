package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.boattypes.Sailboat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Class containing the list of members and their boats.
 */
public class MemberRegistry implements Persistence {
  
  private ArrayList<Member> registry;
  private FileWriter writer;
  private Scanner scanner;

  public MemberRegistry() {
    this.registry = new ArrayList<Member>();
  }

  public Iterable<Member> getRegistry() {
    return new ArrayList<Member>(registry);
  }

  /**
   * Method for adding new member to the registry.

   * @param name Name of member.
   * @param personalNumber Personal number of member.
   */
  public void addMember(String name, String email) {
    Member m;
    String id;
    String uniqueEmail;
    do {
      id = getAlphaNumericString();
    } while (isDuplicateId(id));

    if (!isDuplicateEmail(email)) {
      uniqueEmail = email;
    } else {
      throw new Error("Email is already in use");
    }

    m = new Member(name, uniqueEmail, id);
    registry.add(m);
  }

  /**
   * Method returning a member at a given index.

   * @param index The index of the member.
   * @return Returns a member at the index passed.
   */
  public Member getMemberByIndex(int index) {
    return registry.get(index);
  }

  public void deleteMember(int index) {
    registry.remove(index);
  }


  // Copied and adjusted from https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
  private String getAlphaNumericString() {
    int n = 6;
  
    // chose a Character random from this String
    String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                + "0123456789"
                                + "abcdefghijklmnopqrstuvxyz";

    // create StringBuffer size of AlphaNumericString
    StringBuilder sb = new StringBuilder(n);

    for (int i = 0; i < n; i++) {

      // generate a random number between
      // 0 to AlphaNumericString variable length
      Random ran = new Random();
      int index = ran.nextInt(alphaNumericString.length());

      // add Character one by one in end of sb
      sb.append(alphaNumericString
                        .charAt(index));
    }
    return sb.toString();
  }

  private boolean isDuplicateId(String id) {
    for (Member member : registry) {
      if (id.equals(member.getId())) {
        return true;
      }
    }
    return false;
  }

  private boolean isDuplicateEmail(String email) {
    for (Member member : registry) {
      if (email.equals(member.getEmail())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void saveData() {
    try {
      this.writer = new FileWriter("registry.data");
      writer.write(this.stringifyData());
      writer.close();
    } catch (IOException e) {
      System.out.println("An error occured saving data.");
    }
  }

  @Override
  public void readData() {
    try {
      File file = new File("registry.data");
      scanner = new Scanner(file);
      String data = "";
      while (scanner.hasNextLine()) {
        String nextLine = scanner.nextLine();
        data = data + nextLine + "\n";
      }
      System.out.println(data);
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Couldn't find file");
    }
  }

  @Override
  public String stringifyData() {
    String dataToString = "";
    for (Member member : registry) {
      dataToString = dataToString + "MEMBER:" + member.getName() + ":" + member.getEmail() + ":" + member.getId() + "\n";
      for (Boat boat : member.getFleet()) {
        dataToString = dataToString + "BOAT:" + boat.getName() + ":" + boat.getCharacteristics() + "\n";
      }
    }
    return dataToString;
  }

  @Override
  public void renderData() {
    
  }
}


