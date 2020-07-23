import java.util.Random;
import javax.swing.*;
import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenterBoxFunction {

  public static void mainDraw(Graphics graphics) {
    // create a function that draws one square and takes 2 parameters:
    // the square size and the graphics
    // and draws a square of that size to the center of the canvas.
    // draw 3 squares with that function.
    // avoid code duplication.

    Random random = new Random();
    int edge;
    int limit = Math.min(WIDTH, HEIGHT);
    for (int i = 0; i < 3; i++) {
      edge = random.nextInt(limit);
      drawASquare(graphics, edge);
    }
  }

  public static void drawASquare(Graphics graphics, int edge) {
    int halfHeight = HEIGHT / 2;
    int halfWidth = WIDTH / 2;
    int halfEdge = edge / 2;
    int y = halfHeight - halfEdge;
    int x = halfWidth - halfEdge;
    graphics.drawRect(x, y, edge, edge);
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}