import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen extends JPanel {
    private int[][] pixels = new int[8][8];
    private FloodFillStack FloodFillStack = new FloodFillStack();

    public Screen() {
        for (int i = 0; i < 8; i++) {
            pixels[i][7 - i] = 1;
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pixelSize = 50;
                int x = e.getX() / pixelSize;
                int y = e.getY() / pixelSize;
                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    FloodFillStack.fill(pixels, x, y);
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int pixelSize = 50;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (pixels[x][y] == 1) {
                    g.setColor(Color.BLACK);
                } else if (pixels[x][y] == 2) {
                    g.setColor(Color.BLUE);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
                g.setColor(Color.GRAY);
                g.drawRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }
}
