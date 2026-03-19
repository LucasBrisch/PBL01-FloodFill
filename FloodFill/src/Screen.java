import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    private int[][] pixels = new int[8][8];

    public Screen() {

        for (int i = 0; i < 8; i++) {
            pixels[i][7 - i] = 1;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int pixelSize = 50;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {

                if (pixels[x][y] == 1) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }

                g.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);

                // grid border (for pixel look)
                g.setColor(Color.GRAY);
                g.drawRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }
}
