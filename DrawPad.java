import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DrawPad extends JPanel {
    private final BufferedImage canvas = new BufferedImage(800, 500, BufferedImage.TYPE_INT_RGB);
    private int lastX, lastY;
    private Color color = Color.BLACK;
    private int size = 4;

    public DrawPad() {
        Graphics2D g = canvas.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 500);
        g.dispose();
        setPreferredSize(new Dimension(800, 500));

        MouseAdapter m = new MouseAdapter() {
            public void mousePressed(MouseEvent e) { lastX = e.getX(); lastY = e.getY(); }
            public void mouseDragged(MouseEvent e) {
                Graphics2D g = canvas.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setColor(color);
                g.setStroke(new BasicStroke(size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g.drawLine(lastX, lastY, e.getX(), e.getY());
                g.dispose();
                lastX = e.getX(); lastY = e.getY();
                repaint();
            }
        };
        addMouseListener(m);
        addMouseMotionListener(m);
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, null);
    }

    void clear() {
        Graphics2D g = canvas.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g.dispose();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawPad pad = new DrawPad();
            JButton colorBtn = new JButton("Color");
            colorBtn.addActionListener(e -> {
                Color c = JColorChooser.showDialog(pad, "Pick color", pad.color);
                if (c != null) pad.color = c;
            });
            JButton clearBtn = new JButton("Clear");
            clearBtn.addActionListener(e -> pad.clear());
            JSlider slider = new JSlider(1, 30, 4);
            slider.addChangeListener(e -> pad.size = slider.getValue());

            JPanel bar = new JPanel();
            bar.add(colorBtn); bar.add(clearBtn); bar.add(new JLabel("Size")); bar.add(slider);

            JFrame f = new JFrame("DrawPad");
            f.setLayout(new BorderLayout());
            f.add(bar, BorderLayout.NORTH);
            f.add(pad, BorderLayout.CENTER);
            f.pack();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}
