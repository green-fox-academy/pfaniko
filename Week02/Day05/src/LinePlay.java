import java.awt.image.ImageObserver;
import java.util.Random;
import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
  public static void mainDraw(Graphics graphics) {
    int indent = 20;
    graphics.setColor(Color.MAGENTA);
    drawTopLines(graphics, indent, indent, 0, WIDTH, indent);
    graphics.setColor(Color.GREEN);
    drawBottomLines(graphics, indent, 0, indent, indent, HEIGHT);
  }

  public static void drawTopLines(Graphics graphics, int indent, int x1, int y1, int x2, int y2) {
    for (int i = 0; i < WIDTH / indent; i++) {
      graphics.drawLine(x1, y1, x2, y2);
      x1 = x1 + indent;
      y2 = y2 + indent;
    }
  }

  public static void drawBottomLines(Graphics graphics, int indentBottom, int x1Bottom,
                                     int y1Bottom, int x2Bottom, int y2Bottom) {
    for (int i = 0; i < HEIGHT / indentBottom; i++) {
      graphics.drawLine(x1Bottom, y1Bottom, x2Bottom, y2Bottom);
      y1Bottom = y1Bottom + indentBottom;
      x2Bottom = x2Bottom + indentBottom;
    }
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