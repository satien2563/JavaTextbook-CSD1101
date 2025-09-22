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

public class DrawingSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Drawing - Swing Version");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // แผงวาดภาพ กำหนดขนาด 200x200 ให้เหมือน DWindow(200, 200)
            DrawingPanel panel = new DrawingPanel();
            panel.setPreferredSize(new Dimension(200, 200));

            f.setContentPane(panel);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }

    // แผงสำหรับวาดรูป ใช้แทน DWindow
    static class DrawingPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();
            // ทำให้เส้นเนียน และกำหนดความหนาเส้น
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(1.2f));

            // พิกัดกึ่งกลางเท่ากับ 100,100 เช่นเดิม และขนาดสี่เหลี่ยม d = 120
            int xc = 100, yc = 100, d = 120;

            // วาดสี่เหลี่ยมหมุนทีละ 10 องศา ตั้งแต่ 0 ถึง 80
            for (int a = 0; a < 90; a += 10) {
                drawSquare(g2, xc, yc, d, a);
            }

            g2.dispose();
        }
    }

    // ช่วยแปลงองศาเป็นเรเดียน แล้วคำนวณ sin cos
    static double sin(double deg) {
        return Math.sin(Math.toRadians(deg));
    }

    static double cos(double deg) {
        return Math.cos(Math.toRadians(deg));
    }

    /**
     * วาดสี่เหลี่ยมจัตุรัสโดยหมุนรอบจุด (xc, yc)
     * d คือความยาวด้านของสี่เหลี่ยม
     * a คือมุมหมุนเป็นองศา
     * ใช้หลักเดียวกับเวอร์ชัน DWindow และเรียกวาดเส้นแทน
     */
    static void drawSquare(Graphics2D g2, int xc, int yc, int d, int a) {
        double r = d / (2 * cos(45)); // ระยะจากศูนย์ถึงมุม เมื่อสี่เหลี่ยมเอียง 45 องศา
        double angle = a - 45;        // เริ่มที่มุมซ้ายบนของสี่เหลี่ยมหลังชดเชย 45 องศา

        double x0 = xc + r * cos(angle);
        double y0 = yc - r * sin(angle);

        for (int i = 0; i < 4; i++) {
            angle = angle + 90;
            double x1 = xc + r * cos(angle);
            double y1 = yc - r * sin(angle);

            // ใน Swing ใช้ g2.drawLine ต้องเป็น int จึงปัดค่าทศนิยม
            g2.drawLine((int) Math.round(x0), (int) Math.round(y0),
                    (int) Math.round(x1), (int) Math.round(y1));

            x0 = x1;
            y0 = y1;
        }
    }
}
