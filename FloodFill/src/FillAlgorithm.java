import javax.swing.*;
import java.awt.image.BufferedImage;

public abstract class FillAlgorithm {

    public interface PointStore {
        void add(Point p);
        Point remove();
        boolean isEmpty();
    }

    protected abstract PointStore createStore();

    public void fill(BufferedImage image, int startX, int startY, JPanel panel) {
        if (image == null) return;
        
        int targetColor = image.getRGB(startX, startY);
        int newColor = new java.awt.Color(0x99CFBD).getRGB();

        if (targetColor == newColor) return;

        PointStore store = createStore();
        store.add(new Point(startX, startY));

        new Thread(() -> {
            while (!store.isEmpty()) {
                Point p = store.remove();
                if (p == null) continue;

                int x = p.getX();
                int y = p.getY();

                if (x < 0 || y < 0 || x >= image.getWidth() || y >= image.getHeight())
                    continue;

                if (image.getRGB(x, y) != targetColor)
                    continue;

                image.setRGB(x, y, newColor);

                store.add(new Point(x + 1, y));
                store.add(new Point(x - 1, y));
                store.add(new Point(x, y + 1));
                store.add(new Point(x, y - 1));

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