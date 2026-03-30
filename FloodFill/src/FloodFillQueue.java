import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class FloodFillQueue extends FillAlgorithm {

    @Override
    protected PointStore createStore() {
        return new PointStore() {
            private final Queue<Point> queue = new Queue<>();

            @Override
            public void add(Point p) {
                queue.enqueue(p);
            }

            @Override
            public Point remove() {
                return queue.dequeue();
            }

            @Override
            public boolean isEmpty() {
                return queue.isEmpty();
            }
        };
    }
}