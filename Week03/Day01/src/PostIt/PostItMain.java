package PostIt;

public class PostItMain {
  public static void main(String[] args) {
    PostIt postIt1 = new PostIt("orange", "Idea 1", "blue");
    PostIt postIt2 = new PostIt("pink", "Awesome", "black");
    PostIt postIt3 = new PostIt("yellow", "Superb", "green");

    System.out.println("Background color: " + postIt1.getBackgroundColor());
    System.out.println("Text: " + postIt1.getText());
    System.out.println("Text color: " + postIt1.getTextColor());

    System.out.println("Background color: " + postIt2.getBackgroundColor());
    System.out.println("Text: " + postIt2.getText());
    System.out.println("Text color: " + postIt2.getTextColor());

    System.out.println("Background color: " + postIt3.getBackgroundColor());
    System.out.println("Text: " + postIt3.getText());
    System.out.println("Text color: " + postIt3.getTextColor());

  }
}
