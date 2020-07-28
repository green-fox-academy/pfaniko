package Counter;

public class Counter {
  private int defaultCounter;
  private int counter;

  public Counter(int counter) {
    this.defaultCounter = counter;
    this.counter = counter;
  }

  public void add(int number) {
    this.counter = counter + number;
  }

  public void add() {
    counter++;
  }

  public int get() {
    return counter;
  }

  public void reset() {
    counter = defaultCounter;
  }
}