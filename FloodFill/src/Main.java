import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame("Flood Fill");
        Screen panel = new Screen();

        window.add(panel);
        window.setSize(420, 440);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}