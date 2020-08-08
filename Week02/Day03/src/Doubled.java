import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Doubled {

  public static void main(String[] args) {
    // Create a method that decrypts the duplicated-chars.txt

    removeDuplicates("duplicated-chars.txt");
  }

  public static void removeDuplicates(String fileName) {
    List<String> lines = readFile(fileName);
    List<String> newText = new ArrayList<>();
    for (String line : lines) {
      String tempStringBeginning = "";
      String tempStringEnd = "";
      for (int i = 0; i < line.length() - 1; i++) {
        if (line.charAt(i) == line.charAt(i + 1)) {
          tempStringBeginning = line.substring(0, i);
          tempStringEnd = line.substring(i + 1);
          line = tempStringBeginning + tempStringEnd;
        }
      }
      newText.add(line);
    }
    writeFile(fileName, newText);
  }

  public static List<String> readFile(String fileName) {
    Path path = Paths.get(fileName);
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }

  public static void writeFile(String fileName, List<String> lines) {
    Path path = Paths.get(fileName);
    try {
      Files.write(path, lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}