import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame("Flood Fill");
        // Livia use the logic below f the menu:
        var panel = new Screen(new FloodFillStack());

        window.add(panel);
        window.setSize(420, 440);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}