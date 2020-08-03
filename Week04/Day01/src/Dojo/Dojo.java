package Dojo;

import java.util.ArrayList;

public class Dojo {

  public static Integer checkIfItsInThere(int ifThisIsNotThere, ArrayList theList) {
    int minusOneOrNot = theList.contains(ifThisIsNotThere) ? 0 : (-1);
    return minusOneOrNot;
  }
}