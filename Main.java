import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ayal's App");
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawBallsPanel panel = new DrawBallsPanel();
        panel.setVisible(true);
        frame.add(panel);
        new Thread(panel).start();
    }
}
