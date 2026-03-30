import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageSaver {
    private static final String BASE = "output";

    public static void ensureDirs(String algo) {
        new File(BASE + "/progress/" + algo).mkdirs();
        new File(BASE + "/final/" + algo).mkdirs();
    }

    public static synchronized void saveProgress(BufferedImage image, String algo, int count, long threadId) {
        try {
            BufferedImage copy;
            synchronized (image) {
                copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
                Graphics g = copy.getGraphics();
                g.drawImage(image, 0, 0, null);
                g.dispose();
            }

            String filename = String.format("%s/progress/%s/%06d_thread-%d.png", BASE, algo, count, threadId);
            ImageIO.write(copy, "png", new File(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void saveFinal(BufferedImage image, String algo, long threadId) {
        try {
            BufferedImage copy;
            synchronized (image) {
                copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
                Graphics g = copy.getGraphics();
                g.drawImage(image, 0, 0, null);
                g.dispose();
            }

            String filename = String.format("%s/final/%s/final_thread-%d.png", BASE, algo, threadId);
            ImageIO.write(copy, "png", new File(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

