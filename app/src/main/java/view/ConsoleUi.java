package view;

import java.util.Scanner;
import model.Boat;
import model.Member;
import model.MemberRegistry;

/**
 * Responsible for low level input and all output in the console.
 */
public class ConsoleUi {

  private Scanner terminalInput;

  public ConsoleUi() {
    this.terminalInput = new Scanner(System.in, "UTF-8");
  }

  public void showWelcomeMessage() {
    System.out.println("Welcome to the Yacht Club!");
  }

  public void showMainMenu() {
    System.out.println("a to add member, c to display compact list, v to display verbose list, q to quit");
  }

  /**
   * Displays the compact list of members.
   */
  public void showCompactListMenu(MemberRegistry mr) {
    int index = 1;
    for (Member m : mr.getRegistry()) {
      System.out.println(index + " " + m.getName() + " " + m.getId() + " Number of boats:" + m.getFleetLength());
      index += 1;
    }
    System.out.println("Select number in front of member to select, x to return to main menu, q to quit");
  }

  /**
   * Displays the verbose list of members.
   */
  public void showVerboseListMenu(MemberRegistry mr) {
    int memberIndex = 1;
    for (Member m : mr.getRegistry()) {
      System.out.println(memberIndex + " " + m.getName() + " " + m.getEmail() + " " + m.getId());
      int boatIndex = 1;
      for (Boat b : m.getFleet()) {
        System.out.println("   " + boatIndex + " " + b.getType() + " " + b.getLength() + " metres");
        boatIndex += 1;
      }
      memberIndex += 1;
    }
    System.out.println("Enter number to select member, x to return to main menu, q to quit");
  }

  /**
   * Displays the menu for a specific member.
   */
  public void showMemberMenu(MemberRegistry  mr, int index) {
    Member m = mr.getMemberByIndex(index);
    System.out.println(m.getName() + " " + m.getEmail() + " " + m.getId());
    int boatIndex = 1;
    for (Boat b : m.getFleet()) {
      System.out.println("   " + boatIndex + " " + b.getType() + " " + b.getLength() + " metres");
      boatIndex += 1;
    }
    System.out.println("d to delete, e to edit, b to add boat, x to return to main menu, q to quit");
    System.out.println("Select number in front of boat to select,");
  }

  public void showBoatMenu() {
    System.out.println("d to delete, e to edit, x to return to main menu, q to quit");
  }

  public void addMemberNameMessage() {
    System.out.println("To add new member, enter full name followed by ENTER");
  }

  public void addMemberEmailMessage() {
    System.out.println("Now enter email address followed by ENTER");
  }

  public void memberAddedMessage() {
    System.out.println("New member added.");
  }

  public void enterNewValueMessage() {
    System.out.println("Please enter new value, then hit ENTER");
  }

  public void addBoatTypeMessage() {
    System.out.println("Enter a boat type: (s) Sailboat, (m) Motorsailer, (k) Canoe, (w) Motorsailer");
  }

  public void addBoatDepthMessage() {
    System.out.println("Enter the depth of boat in metres:");
  }

  public void addBoatLengthMessage() {
    System.out.println("Enter length of boat in metres:");
  }

  public void addBoatEnginePowerMessage() {
    System.out.println("Enter engine power of boat in horse powers:");
  }

  public void newBoatMessage() {
    System.out.println("New boat added");
  }

  public void editBoatMessage() {
    System.out.println("t to edit boat type, l to edit length");
  }

  public void invalidInputMessage() {
    System.out.println("Invalid input. Return to main menu.");
  }


  /**
   * Method for retrieving input in the form of one character.
   */
  public int getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      terminalInput.nextLine();
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }

  public String getStringInput() {
    String input = terminalInput.nextLine();
    return input;
  }

  public boolean wantsToQuit(int userInput) {
    return (userInput == 'q');
  }

  public boolean wantsToExit(int userInput) {
    return (userInput == 'x');
  }

  public boolean wantsToAddMember(int userInput) {
    return (userInput == 'a');
  }

  public boolean wantsToShowCompact(int userInput) {
    return (userInput == 'c');
  }

  public boolean wantsToShowVerbose(int userInput) {
    return (userInput == 'v');
  }

  public boolean inputIsNumber(int userInput) {
    return (userInput > '0' && userInput <= '9');
  }

  public int inputToNumber(int userInput) {
    return (userInput - 49);
  }

  public boolean wantsToDeleteMember(int userInput) {
    return (userInput == 'd');
  }

  public boolean wantsToEditMember(int userInput) {
    return (userInput == 'e');
  }

  public boolean wantsToAddNewBoat(int userInput) {
    return (userInput == 'b');
  }

  public boolean wantsToAddSailboat(int userInput) {
    return (userInput == 's');
  }

  public boolean wantsToAddMotorsailer(int userInput) {
    return (userInput == 'w');
  }

  public boolean wantsToAddKayakcanoe(int userInput) {
    return (userInput == 'k');
  }

  public boolean wantsToAddMotorboat(int userInput) {
    return (userInput == 'm');
  }

  public boolean wantsToEditBoatType(int userInput) {
    return (userInput == 't');
  }

  public boolean wantsToEditBoatLength(int userInput) {
    return (userInput == 'l');
  }

}
