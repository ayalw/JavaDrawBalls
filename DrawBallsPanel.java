import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawBallsPanel extends JPanel implements Runnable {

    private int numOfBalls = 0;
    private Point lastClick;

    public DrawBallsPanel() {
        super();
        this.setSize(800,800);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                lastClick = e.getPoint();
                numOfBalls++;
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i=0; i<numOfBalls; i++) {
            drawRandomBall(g);
        }
        if (lastClick != null) {
            drawBall(g, lastClick.x, lastClick.y);
            lastClick = null;
        }
    }


    @Override
    public void run() {
        while (true) {
            removeAll();
            repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void drawBall(Graphics g, int x, int y) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 10, 10);
    }

    public void drawRandomBall(Graphics g) {
        int sizeX = getWidth();
        int sizeY = getHeight();
        int x = (int) (Math.random() * sizeX);
        int y = (int) (Math.random() * sizeY);
        drawBall(g, x, y);
    }
}
