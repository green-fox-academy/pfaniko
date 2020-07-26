import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class AppendAFunc {
//  Create the usual class wrapper
//  and main method on your own.

// - Create a string variable named `typo` and assign the value `Chinchill` to it
// - Write a function called `appendAFunc` that gets a string as an input,
//   appends an 'a' character to its end and returns with a string
//
// - Print the result of `appendAFunc(typo)`

  public static void main(String[] args) {
    String typo = "Chinchill";
    appendAFunc(typo);
  }

  public static void appendAFunc(String typo) {
    System.out.println(typo + "a");
  }
}
