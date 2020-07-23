import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenteredSquare {

  public static void mainDraw(Graphics graphics) {
    // Draw a green 10x10 square to the canvas' center.

    int edge = 10;
    int halfHeight = HEIGHT / 2;
    int halfWidth = WIDTH / 2;
    int halfEdge = edge / 2;
    int[] xCoordinates =
        {halfWidth - halfEdge, halfWidth + halfEdge, halfWidth + halfEdge, halfWidth - halfEdge};
    int[] yCoordinates =
        {halfHeight - halfEdge, halfHeight - halfEdge, halfHeight + halfEdge,
            halfHeight + halfEdge};
    graphics.setColor(Color.GREEN);
    graphics.drawPolygon(xCoordinates, yCoordinates, xCoordinates.length);
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