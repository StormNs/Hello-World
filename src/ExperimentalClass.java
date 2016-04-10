
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExperimentalClass {

    // as much as possible, don't use the water in the tank when they're off
    // because it can cause air locks. You'll get no water anyway if the tank is
    // evtmpty
    public static void main(String[] args) throws Exception {
        JFrame f = new JFrame("Draw a red line");
        f.setSize(300, 300);
        f.setLocation(300, 300);
        f.setResizable(false);

        JPanel p = new JPanel() {
            Point p1 = null;
            Point p2 = null;

            {
                addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent evt) {
                        p1 = evt.getPoint();

                    }

                    public void mouseReleased(MouseEvent evt) {
                        p1 = null;

                    }
                });
                addMouseMotionListener(new MouseMotionAdapter() {
                    public void mouseMoved(MouseEvent evt) {
                        p2 = evt.getPoint();
                    }

                    public void mouseDragged(MouseEvent evt) {
                        p2 = evt.getPoint();
                        repaint();
                    }
                });
            }

            @Override
            public void paint(Graphics g) {
                super.paint(g);
                if (p1 != null) {
                    g.setColor(Color.red);
                    g.drawLine(p1.x, p1.y, p2.x,
                            p2.y);

                }
            }
        };
        f.add(p);
        f.setVisible(true);

    }
}
