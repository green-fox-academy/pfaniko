package Dojo;

import static Dojo.Dojo.checkIfItsInThere;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class DojoTest {
  @Test
  void returnMinusOneIfNotThere() {
    ArrayList<Integer> theList = new ArrayList<>();
    for (int i = 0; i < (int) (1 + Math.random() * 100); i++) {
      theList.add((int) (1 + Math.random() * 100));
    }
    int ifThisIsNotThere = (int) (1 + Math.random() * 100);
    int minusOneOrNot = theList.contains(ifThisIsNotThere) ? 0 :(-1);
    assertEquals(minusOneOrNot, (checkIfItsInThere(ifThisIsNotThere, theList)));
  }
}