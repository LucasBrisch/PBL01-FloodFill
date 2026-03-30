import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class FloodFillQueue implements FillAlgorithm {

    @Override
    public void fill(BufferedImage image, int startX, int startY, JPanel panel) {
        Queue<Point> queue = new Queue<>();
        int targetColor = image.getRGB(startX, startY);
        int newColor = new Color(0x99CFBD).getRGB();

        if (targetColor == newColor) return;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        queue.enqueue(new Point(startX, startY));

        ImageSaver.ensureDirs("queue");

        new Thread(() -> {
            int paintedCount = 0;
            long threadId = Thread.currentThread().getId();

            while (!queue.isEmpty()) {
                Point p = queue.dequeue();
                int x = p.getX();
                int y = p.getY();

                if (x < 0 || y < 0 || x >= image.getWidth() || y >= image.getHeight())
                    continue;

                if (image.getRGB(x, y) != targetColor)
                    continue;

                image.setRGB(x, y, newColor);
                paintedCount++;

                if (paintedCount % 10 == 0) {
                    ImageSaver.saveProgress(image, "queue", paintedCount, threadId);
                }

                for (int i = 0; i < 4; i++) {
                    int newX = x + directions[i][0];
                    int newY = y + directions[i][1];

                    queue.enqueue(new Point(newX, newY));
                }

                panel.repaint();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ImageSaver.saveFinal(image, "queue", threadId);
        }).start();
    }
}