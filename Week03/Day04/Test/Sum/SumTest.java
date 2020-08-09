package Sum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumTest {
  private static Sum sum;
  private static ArrayList<Integer> things;


  @BeforeEach
  public void setup() {
    things = new ArrayList<>();
    sum = new Sum(things);
  }

  @Test
  void test1() {
    assertEquals(0, Sum.sumElements(things));
  }

  @Test
  void test2() {
    int a = (int) (1 + Math.random() * 100);
    things.add(a);
    assertEquals(a, Sum.sumElements(things));
  }

  @Test
  void test3() {
    int a = (int) (1 + Math.random() * 100);
    int b = (int) (1 + Math.random() * 100);
    int c = (int) (1 + Math.random() * 100);
    things.add(a);
    things.add(b);
    things.add(c);

    assertEquals(a + b + c, Sum.sumElements(things));
  }

  @Test
  void test4() {
    ArrayList<Integer> things2 = new ArrayList<>();
    things2 = null;
    assertNull(Sum.sumElements(things2));
  }
}