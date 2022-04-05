package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class containing the list of members and their boats.
 */
public class MemberRegistry implements Persistence {
  
  private ArrayList<Member> registry;

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
  public void addMember(String name, long personalNumber) {
    Member m;
    String id;
    do {
      id = getAlphaNumericString();
    } while (isDuplicateId(id));

    m = new Member(name, personalNumber, id);
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
}


