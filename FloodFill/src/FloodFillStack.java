import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;

public class FloodFillStack implements FillAlgorithm {

    @Override
    public void fill(BufferedImage image, int startX, int startY, JPanel panel) {
        Stack<Point> stack = new Stack<>();
        int targetColor = image.getRGB(startX, startY);
        int newColor = Color.BLUE.getRGB();

        if (targetColor == newColor) return;

        stack.push(new Point(startX, startY));

        new Thread(() -> {
            while (!stack.isEmpty()) {
                Point p = stack.pop();
                if (p == null) continue;

                int x = p.getX();
                int y = p.getY();

                if (x < 0 || y < 0 || x >= image.getWidth() || y >= image.getHeight())
                    continue;

                if (image.getRGB(x, y) != targetColor)
                    continue;

                image.setRGB(x, y, newColor);

                stack.push(new Point(x + 1, y));
                stack.push(new Point(x - 1, y));
                stack.push(new Point(x, y + 1));
                stack.push(new Point(x, y - 1));

                panel.repaint();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}