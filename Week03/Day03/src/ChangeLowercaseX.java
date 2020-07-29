public class ChangeLowercaseX {
  public static void main(String[] args) {
//    Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.

    String string = "sa dékű WUR ASŐIDÖF FH Xxp xxaosh";
    System.out.println(changeLowercaseX(string));
  }

  public static String changeLowercaseX(String string) {
    if (string.length() == 0) {
      return string;
    } else if (string.charAt(0) == 'x') {
      return 'Y' + changeLowercaseX(string.substring(1));
    } else {
      return string.charAt(0) + changeLowercaseX(string.substring(1));
    }
  }
}