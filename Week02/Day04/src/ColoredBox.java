import java.util.Random;
import javax.swing.*;
import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBox {
  public static void mainDraw(Graphics graphics) {
    // Draw a box that has different colored lines on each edge.

    int edge = 150;
    int halfHeight = HEIGHT / 2;
    int halfWidth = WIDTH / 2;
    int halfEdge = edge / 2;
    int x1 = (halfWidth - halfEdge);
    int x2 = (halfWidth + halfEdge);
    int y1 = (halfHeight - halfEdge);
    int y2 = (halfHeight + halfEdge);

    drawOneEdgeWithDifferentColor(graphics, x1, y1, x1, y2);
    drawOneEdgeWithDifferentColor(graphics, x1, y2, x2, y2);
    drawOneEdgeWithDifferentColor(graphics, x2, y2, x2, y1);
    drawOneEdgeWithDifferentColor(graphics, x2, y1, x1, y1);
  }

  public static void drawOneEdgeWithDifferentColor(Graphics graphics, int a, int b, int c,
                                                   int d) {
    graphics.setColor(getRandomColor());
    graphics.drawLine(a, b, c, d);
  }

  public static Color getRandomColor() {
    Random random = new Random();
    int limit = 256;
    return new Color(random.nextInt(limit), random.nextInt(limit), random.nextInt(limit));
  }

  // Don't touch the code below
  static int WIDTH = 1500;
  static int HEIGHT = 800;

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