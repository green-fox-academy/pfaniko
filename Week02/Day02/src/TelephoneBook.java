import java.util.HashMap;

public class TelephoneBook {
  public static void main(String[] args) {
//  We are going to represent our contacts in a map where the keys are going to be strings and the values are going to be strings as well.
//
//  Create a map with the following key-value pairs.
//      Name (key) 	Phone number (value)
//      William A. Lathan 	405-709-1865
//      John K. Miller 	402-247-8568
//      Hortensia E. Foster 	606-481-6467
//      Amanda D. Newland 	319-243-5613
//      Brooke P. Askew 	307-687-2982
//
//  Create an application which solves the following problems.
//      What is John K. Miller's phone number?
//      Whose phone number is 307-687-2982?
//      Do we know Chris E. Myers' phone number?

    HashMap<String, String> telephoneBook = new HashMap<>();
    telephoneBook.put("William A. Lathan", "405-709-1865");
    telephoneBook.put("John K. Miller", "402-247-8568");
    telephoneBook.put("Hortensia E. Foster", "606-481-6467");
    telephoneBook.put("Amanda D. Newland", "319-243-5613");
    telephoneBook.put("Brooke P. Askew", "307-687-2982");

    System.out.println("John K. Miller's phone number is: " +
        findWhatIsTheNumber(telephoneBook, "John K. Miller"));
    System.out.println("307-687-2982 is the phone number of: " +
        findWhoseNumberIsIt(telephoneBook, "307-687-2982"));
    System.out.println("Do we know Chris E. Meyers' phone number? " +
        isPhoneNumberKnown(telephoneBook, "Chris E. Meyers"));
  }

  public static String findWhatIsTheNumber(HashMap<String, String> telephoneBook, String name) {
    return telephoneBook.get(name);
  }

  public static String findWhoseNumberIsIt(HashMap<String, String> telephoneBook, String number) {
    for (HashMap.Entry<String, String> entry : telephoneBook.entrySet()) {
      if (entry.getValue().equals(number)) {
        return entry.getKey();
      }
    }
    return null;
  }

  public static String isPhoneNumberKnown(HashMap<String, String> telephoneBook, String name) {
    if (telephoneBook.containsKey(name)) {
      return "Yes";
    } else {
      return "No";
    }
  }
}