import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] options = {"Stack", "Queue"};

        int choice = JOptionPane.showOptionDialog(null,
                "Choose an algorithm:",
                "Flood Fill",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        if (choice == JOptionPane.CLOSED_OPTION) return;

        FillAlgorithm algorithm = (choice == 0) ? new FloodFillStack() : new FloodFillQueue();
        String windowName = (choice == 0) ? "Stack - Flood Fill" : "Queue - Flood Fill";

        JFrame window = new JFrame(windowName);
        var panel = new Screen(algorithm);

        window.add(panel);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}