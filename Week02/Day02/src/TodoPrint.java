public class TodoPrint {
  public static void main(String[] args) {
    String todoText = " - Buy milk\n";
    // Add "My todo:" to the beginning of the todoText
    // Add " - Download games" to the end of the todoText
    // Add " - Diablo" to the end of the todoText but with indention

    // Expected output:

    // My todo:
    //  - Buy milk
    //  - Download games
    //      - Diablo
    todoText = "My todo:\n" + todoText;
    String text1 = " - Download Games\n";
    String text2 = " - Diablo";
    String indent = "\t";
    todoText = todoText.concat(text1).concat(indent).concat(text2);
    System.out.println(todoText);
  }
}