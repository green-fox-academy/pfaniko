import java.util.ArrayList;

public class PersonalFinance {
  public static void main(String[] args) {
    ArrayList<Integer> listOfNumbers = new ArrayList<>();
    listOfNumbers.add(500);
    listOfNumbers.add(1000);
    listOfNumbers.add(1250);
    listOfNumbers.add(175);
    listOfNumbers.add(800);
    listOfNumbers.add(120);

    calculatePersonalFinances(listOfNumbers);
  }

  public static void calculatePersonalFinances(ArrayList<Integer> listOfNumbers){
    System.out.println("We spent: " + calculateSpentAmount(listOfNumbers));
    System.out.println("The greatest expense was: " + findGreatestExpense(listOfNumbers));
    System.out.println("The cheapest spending was: " + findCheapestSpending(listOfNumbers));
    System.out.println("The average amount of our spending was: " + calculateAverageSpending(listOfNumbers));
  }

  public static Integer calculateSpentAmount(ArrayList<Integer> listOfNumbers) {
    int sum = 0;
    for (int number : listOfNumbers) {
      sum = sum + number;
    }
    return sum;
  }

  public static Integer findGreatestExpense(ArrayList<Integer> listOfNumbers) {
    int greatestExpense = 0;
    for (int number : listOfNumbers) {
      if (number > greatestExpense) {
        greatestExpense = number;
      }
    }
    return greatestExpense;
  }

  public static Integer findCheapestSpending(ArrayList<Integer> listOfNumbers) {
    int cheapestSpending = Integer.MAX_VALUE;
    for (int number : listOfNumbers) {
      if (number < cheapestSpending) {
        cheapestSpending = number;
      }
    }
    return cheapestSpending;
  }

  public static Integer calculateAverageSpending(ArrayList<Integer> listOfNumbers) {
    int sum = 0;
    for (int number : listOfNumbers) {
      sum = sum + number;
    }
    return sum / (listOfNumbers.size());
  }
}
