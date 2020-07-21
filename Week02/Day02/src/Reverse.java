import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class Reverse {
  public static void main(String[] args) {
    String toBeReversed =
        ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
//
////    // Create a method that can reverse a String, which is passed as the parameter
////    // Use it on this reversed string to check it!
////    // Try to solve this using charAt() first, and optionally anything else after.
//
    System.out.println(reverse(toBeReversed));
  }

  public static String reverse(String original) {
    String reverse = "";
    for (int i = original.length() - 1; i >= 0; i--) {
      char letter = original.charAt(i);
      reverse = reverse + letter;
    }
    return reverse;
  }
}