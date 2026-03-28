import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame("Flood Fill");
        // Livia use the logic below f the menu:
        var panel = new Screen(new FloodFillQueue());

        window.add(panel);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}