package Sum;

import java.util.ArrayList;

public class Sum {
  private ArrayList<Integer> elements;

  public Sum(ArrayList<Integer> elements) {
    this.elements = elements;
  }

  public static Integer sumElements(ArrayList<Integer> elements) {
    if (elements == null) {
      return null;
    }
    int sum = 0;
    for (int element : elements) {
      sum = sum + element;
    }
    return sum;
  }
}