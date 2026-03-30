import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Screen extends JPanel {
    private BufferedImage image;
    private final FillAlgorithm fillAlgorithm;

    public Screen(FillAlgorithm fillAlgorithm) {
        this.fillAlgorithm = fillAlgorithm;

        try {
            File imgFile = new File("img.png");
            if (!imgFile.exists()) {
                imgFile = new File("FloodFill/img.png");
            }
            if (!imgFile.exists()) {
                imgFile = new File("src/img.png");
            }
            image = ImageIO.read(imgFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                fillAlgorithm.fill(image, x, y, Screen.this);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
