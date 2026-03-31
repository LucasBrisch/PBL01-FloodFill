import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageSaver {
    private static final String BASE = "output";

    public static void ensureDirs(String algorithm) {
        new File(BASE + "/progress/" + algorithm).mkdirs();
        new File(BASE + "/final/" + algorithm).mkdirs();
    }

    public static synchronized void saveImage(BufferedImage image, String algorithm, boolean isFinal, Integer count, long threadId) {
        try {
            BufferedImage copy;
            synchronized (image) {
                copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
                Graphics g = copy.getGraphics();
                g.drawImage(image, 0, 0, null);
                g.dispose();
            }

            String filename;
            if (isFinal) {
                filename = String.format("%s/final/%s/final_thread-%d.png", BASE, algorithm, threadId);
            } else {
                if (count == null) {
                    throw new IllegalArgumentException("count must be provided for progress images");
                }
                filename = String.format("%s/progress/%s/%06d_thread-%d.png", BASE, algorithm, count, threadId);
            }

            ImageIO.write(copy, "png", new File(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
