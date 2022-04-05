package controller;

import model.MemberRegistry;
import model.boattypes.Canoe;
import model.boattypes.Sailboat;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.
   */
  public static void main(String[] args) {

    MemberRegistry mr = new MemberRegistry();

    mr.addMember("Johanna Ringström", "jo@gmail.com");
    mr.getMemberByIndex(0).addBoat(new Sailboat("Bajs", 3, 7));
    mr.addMember("Test Testsson", "test@test.com");
    mr.getMemberByIndex(1).addBoat(new Canoe("Poop", 7));

    User u = new User();
    view.ConsoleUi v = new view.ConsoleUi();

    u.startApplication(v, mr);
  }
}
