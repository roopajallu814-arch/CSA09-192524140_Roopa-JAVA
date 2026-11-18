import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Intentionally buggy version for debugging practice. Compare with DrawPad.java.
public class BuggyDrawPad extends JPanel {
    private final ArrayList<Point> points = new ArrayList<>();
    private Color color = Color.BLACK;

    public BuggyDrawPad() {
        setPreferredSize(new Dimension(800, 500));
        setBackground(Color.WHITE);
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                // BUG 1: repaint() is never called, so nothing shows until the window is resized
            }
        });
    }

    @Override protected void paintComponent(Graphics g) {
        // BUG 2: super.paintComponent(g) missing -> background is not cleared properly
        g.setColor(color);
        // BUG 3: off-by-one, loop runs to points.size() -> IndexOutOfBoundsException
        for (int i = 0; i <= points.size(); i++) {
            Point p = points.get(i);
            g.fillOval(p.x, p.y, 4, 4);
        }
        // BUG 4: dots only, no lines between points, and no gap handling between strokes
    }

    void clear() {
        // BUG 5: clears the list but never repaints
        points.clear();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("BuggyDrawPad");
        f.add(new BuggyDrawPad());
        f.pack();
        // BUG 6: missing setDefaultCloseOperation -> program keeps running after window closes
        f.setVisible(true);
    }
}
