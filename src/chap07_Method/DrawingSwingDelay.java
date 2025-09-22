package chap07_Method;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class DrawingSwingDelay {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Drawing with Delay - Swing Version");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DrawingPanel panel = new DrawingPanel();
            panel.setPreferredSize(new Dimension(200, 200));

            f.setContentPane(panel);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);

            // เริ่มการวาดแบบทีละรอบ (1 วินาทีต่อรอบ)
            panel.startDrawing();
        });
    }

    static class DrawingPanel extends JPanel {
        private int currentAngle = 0;  // มุมปัจจุบัน
        private final int xc = 100, yc = 100, d = 120;

        // ใช้ Timer เพื่อดีเลย์การวาด
        private Timer timer;

        void startDrawing() {
            timer = new Timer(1000, e -> { // ทุก ๆ 1000 ms = 1 วินาที
                if (currentAngle < 90) {
                    repaint(); // สั่งวาดใหม่
                    currentAngle += 10;
                } else {
                    timer.stop(); // วาดครบแล้ว หยุด Timer
                }
            });
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(1.5f));

            // วาดรูปที่เสร็จแล้วทั้งหมด จนถึง currentAngle
            for (int a = 0; a < currentAngle; a += 10) {
                drawSquare(g2, xc, yc, d, a);
            }

            g2.dispose();
        }
    }

    static double sin(double deg) {
        return Math.sin(Math.toRadians(deg));
    }

    static double cos(double deg) {
        return Math.cos(Math.toRadians(deg));
    }

    static void drawSquare(Graphics2D g2, int xc, int yc, int d, int a) {
        double r = d / (2 * cos(45));
        double angle = a - 45;

        double x0 = xc + r * cos(angle);
        double y0 = yc - r * sin(angle);

        for (int i = 0; i < 4; i++) {
            angle = angle + 90;
            double x1 = xc + r * cos(angle);
            double y1 = yc - r * sin(angle);

            g2.drawLine((int) Math.round(x0), (int) Math.round(y0),
                    (int) Math.round(x1), (int) Math.round(y1));

            x0 = x1;
            y0 = y1;
        }
    }
}
