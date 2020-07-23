import java.util.Random;
import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {

  public static void mainDraw(Graphics graphics) {
    // draw four different size and color rectangles.
    // avoid code duplication.

    int x = 20;
    int y = 50;
    int height = 50;
    int width = 50;
    for (int i = 0; i < 4; i++) {
      graphics.setColor(getRandomColor());
      graphics.drawRect(x, y, width, height);
      Random random = new Random();
      x = random.nextInt(WIDTH);
      y = random.nextInt(HEIGHT);
      int limitHeight = HEIGHT - y;
      int limitWidth = WIDTH - x;
      height = random.nextInt(limitHeight);
      width = random.nextInt(limitWidth);
    }
  }

  public static Color getRandomColor() {
    Random random = new Random();
    int limit = 256;
    return new Color(random.nextInt(limit), random.nextInt(limit), random.nextInt(limit));
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