package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import model.boattypes.Canoe;
import model.boattypes.Motorboat;
import model.boattypes.Motorsailer;
import model.boattypes.Sailboat;

/**
 * Class containing the list of members and their boats.
 */
public class MemberRegistry implements Persistence {
  
  private ArrayList<Member> registry;
  private FileWriter writer;

  public MemberRegistry() {
    this.registry = new ArrayList<Member>();
  }

  public Iterable<Member> getRegistry() {
    return new ArrayList<Member>(registry);
  }

  /**
   * Method for adding new member to the registry.

   * @param name Name of member.
   * @param email Personal email of member.
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
      writer.write("\n" + this.stringifyData());
      writer.close();
    } catch (IOException e) {
      System.out.println("An error occured saving data.");
    }
  }

  @Override
  public void readData() {
    try {
      File file = new File("registry.data");
      Member member = new Member("Test", "Test", "Test");
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String str = scanner.nextLine();
        Scanner lineScanner = new Scanner(str);
        lineScanner.useDelimiter(":");
        while (lineScanner.hasNext()) {
          String unit = lineScanner.next();
          if (unit.equals("MEMBER")) {
            String name = lineScanner.next();
            String email = lineScanner.next();
            String id = lineScanner.next();
            member = new Member(name, email, id);
            registry.add(member);
          } else if (unit.equals("BOAT")) {
            Boat boat = new Canoe("Test", 1);
            String name = lineScanner.next();
            String type = lineScanner.next();
            if (type.equals("sailboat")) {
              int length = Integer.valueOf(lineScanner.next());
              int depth = Integer.valueOf(lineScanner.next());
              boat = new Sailboat(name, length, depth);
            } else if (type.equals("motorboat")) {
              int length = Integer.valueOf(lineScanner.next());
              int enginePower = Integer.valueOf(lineScanner.next());
              boat = new Motorboat(name, length, enginePower);
            } else if (type.equals("motorsailer")) {
              int length = Integer.valueOf(lineScanner.next());
              int depth = Integer.valueOf(lineScanner.next());
              int enginePower = Integer.valueOf(lineScanner.next());
              new Motorsailer(name, length, depth, enginePower);
            } else if (type.equals("canoe")) {
              int length = Integer.valueOf(lineScanner.next());
              boat = new Canoe(name, length);
            }
            member.addBoat(boat);
          }
        }
        lineScanner.close();
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Couldn't find file");
    }

  }

  @Override
  public String stringifyData() {
    String dataToString = "";
    for (Member member : registry) {
      dataToString = dataToString + "MEMBER:" + member.getName() 
        + ":" + member.getEmail() + ":" + member.getId() + "\n";
      for (Boat boat : member.getFleet()) {
        dataToString = dataToString + "BOAT:" + boat.getName() + ":" + boat.getCharacteristics() + "\n";
      }
    }
    return dataToString;
  }
}


