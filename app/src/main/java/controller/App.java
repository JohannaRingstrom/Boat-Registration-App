package controller;

import model.BoatType;
import model.MemberRegistry;

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
    mr.getMemberByIndex(0).addBoat(BoatType.Sailboat, 45);
    mr.addMember("Test Testsson", "test@test.com");
    mr.getMemberByIndex(1).addBoat(BoatType.KayakCanoe, 3);

    User u = new User();
    view.ConsoleUi v = new view.ConsoleUi();

    u.startApplication(v, mr);
  }
}
