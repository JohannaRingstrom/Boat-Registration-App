package controller;

import model.BoatType;
import model.MemberRegistry;
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


      } else if (v.wantsToShowVerbose(userInput)) {
        v.showVerboseListMenu(mr);
        navigateMemberListMenu(v, mr);
          
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
      } else if (v.wantsToEditMember(userInput)) {
        v.editMemberMessage();
        userInput = v.getInput();

        /*if (v.wantsToEditMemberName(userInput)) {
          v.enterNewValueMessage();
          String name = v.getStringInput();
          mr.getMemberByIndex(index).setName(name);
        } else if (v.wantsToEditMemberPersonalNumber(userInput)) {
          v.enterNewValueMessage();
          Long personalNumber = parseStringToLong(v.getStringInput());
          mr.getMemberByIndex(index).setPersonalNumber(personalNumber);
        }*/
      } else if (v.wantsToAddNewBoat(userInput)) {
        addNewBoat(v, mr, index);
      } else if (v.inputIsNumber(userInput)) {
        editBoat(v, mr, index, (v.inputToNumber(userInput)));
      }
    }
  }

  private void addNewBoat(ConsoleUi v, MemberRegistry mr, int index) {
    BoatType type;
    
    v.addBoatTypeMessage();
    userInput = v.getInput();

    if (v.wantsToAddSailboat(userInput)) {
      type = BoatType.Sailboat;
    } else if (v.wantsToAddMotorsailer(userInput)) {
      type = BoatType.Motorsailer;
    } else if (v.wantsToAddKayakcanoe(userInput)) {
      type = BoatType.KayakCanoe;
    } else if (v.wantsToAddOtherBoat(userInput)) {
      type = BoatType.Other;
    } else {
      v.invalidInputMessage();
      return;
    }

    v.addBoatLengthMessage();
    int length = parseStringToInt(v.getStringInput());

    mr.getMemberByIndex(index).addBoat(type, length);
    v.newBoatMessage();
  }


  /**
   * Method for editing a Boat object.

   * @param v The view.
   * @param mr The MemberRegistry where all data is stored.
   * @param memberIndex The indoex of the Member in the list.
   * @param boatIndex The index of the Boat in the list of the member.
   */
  public void editBoat(ConsoleUi v, MemberRegistry mr, int memberIndex, int boatIndex) {
    BoatType type;
    int length;

    v.editBoatMessage();
    userInput = v.getInput();

    if (v.wantsToEditBoatType(userInput)) {
      v.addBoatTypeMessage();
      userInput = v.getInput();

      if (v.wantsToAddSailboat(userInput)) {
        type = BoatType.Sailboat;
      } else if (v.wantsToAddMotorsailer(userInput)) {
        type = BoatType.Motorsailer;
      } else if (v.wantsToAddKayakcanoe(userInput)) {
        type = BoatType.KayakCanoe;
      } else if (v.wantsToAddOtherBoat(userInput)) {
        type = BoatType.Other;
      } else {
        v.invalidInputMessage();
        return;
      }
      mr.getMemberByIndex(memberIndex).getBoatByIndex(boatIndex).setType(type);

    } else if (v.wantsToEditBoatLength(userInput)) {
      v.addBoatLengthMessage();
      length = parseStringToInt(v.getStringInput());
      mr.getMemberByIndex(memberIndex).getBoatByIndex(boatIndex).setLength(length);
    }
  }

  public Long parseStringToLong(String s) {
    return Long.parseLong(s);
  }

  public Integer parseStringToInt(String s) {
    return Integer.parseInt(s);
  }
}
