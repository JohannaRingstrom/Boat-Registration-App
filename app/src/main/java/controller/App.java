package controller;

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

    User u = new User();
    view.ConsoleUi v = new view.ConsoleUi();

    u.startApplication(v, mr);
  }
}
