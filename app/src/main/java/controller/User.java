package controller;

import model.Boat;
import model.MemberRegistry;
import model.boattypes.Canoe;
import model.boattypes.Motorboat;
import model.boattypes.Motorsailer;
import model.boattypes.Sailboat;
import view.ConsoleUi;

/**
 * The main controller of the application.
 */
public class User {

  int userInput;

  /**
   * Gets a message from the model and tells the view to show it.

   * @param v The view used to show the message.
   * @param mr The data collection to read and write.
   */
  public void startApplication(ConsoleUi v, MemberRegistry mr) {
    v.showWelcomeMessage();
    mr.readData();

    do {
      v.showMainMenu();
      userInput = v.getInput();
      if (v.wantsToExit(userInput)) {
        v.showMainMenu();
  
      } else if (v.wantsToAddMember(userInput)) {
  
        v.addMemberNameMessage();
        String name = v.getStringInput();
        v.addMemberEmailMessage();
        String email = v.getStringInput();
        mr.addMember(name, email);
  
      } else if (v.wantsToShowCompact(userInput)) {
        v.showCompactListMenu(mr);
        navigateMemberListMenu(v, mr);

      } else if (v.wantsToQuit(userInput)) {
        mr.saveData();
      }

    } while (!v.wantsToQuit(userInput));

  }

  private void navigateMemberListMenu(ConsoleUi v, MemberRegistry mr) {
    userInput = v.getInput();

    if (v.inputIsNumber(userInput)) {
      int index = (v.inputToNumber(userInput));
      v.showMemberMenu(mr, (index));
      userInput = v.getInput();
      if (v.wantsToDeleteMember(userInput)) {
        mr.deleteMember(index);
      } else if (v.wantsToAddNewBoat(userInput)) {
        addNewBoat(v, mr, index);
      } else if (v.inputIsNumber(userInput)) {
        v.showBoatMenu();
      } else {
        v.invalidInputMessage();
      }
    }
  }

  private void addNewBoat(ConsoleUi v, MemberRegistry mr, int index) {
    
    v.addBoatTypeMessage();
    userInput = v.getInput();

    v.addBoatLengthMessage();
    int length = parseStringToInt(v.getStringInput());

    v.addBoatNameMessage();
    String name = v.getStringInput();

    Boat boat;

    if (v.wantsToAddSailboat(userInput)) {
      v.addBoatDepthMessage();
      int depth = parseStringToInt(v.getStringInput());
      boat = new Sailboat(name, length, depth);
    } else if (v.wantsToAddMotorsailer(userInput)) {
      v.addBoatEnginePowerMessage();
      int enginePower = parseStringToInt(v.getStringInput());
      int depth = parseStringToInt(v.getStringInput());
      boat = new Motorsailer(name, length, depth, enginePower);
    } else if (v.wantsToAddKayakcanoe(userInput)) {
      boat = new Canoe(name, length);
    } else if (v.wantsToAddMotorboat(userInput)) {
      v.addBoatEnginePowerMessage();
      int enginePower = parseStringToInt(v.getStringInput());
      boat = new Motorboat(name, length, enginePower);
    } else {
      v.invalidInputMessage();
      return;
    }

    mr.getMemberByIndex(index).addBoat(boat);
    v.newBoatMessage();
  }

  public Long parseStringToLong(String s) {
    return Long.parseLong(s);
  }

  public Integer parseStringToInt(String s) {
    return Integer.parseInt(s);
  }
}
