import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;

public class FloodFillStack extends FillAlgorithm {

    @Override
    protected PointStore createStore() {
        return new PointStore() {
            private final Stack<Point> stack = new Stack<>();

            @Override
            public void add(Point p) {
                stack.push(p);
            }

            @Override
            public Point remove() {
                return stack.pop();
            }

            @Override
            public boolean isEmpty() {
                return stack.isEmpty();
            }
        };
    }
}