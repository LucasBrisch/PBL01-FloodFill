import javax.swing.*;
import java.awt.image.BufferedImage;

public interface FillAlgorithm {
    void fill(BufferedImage image, int startX, int startY, JPanel panel);
}