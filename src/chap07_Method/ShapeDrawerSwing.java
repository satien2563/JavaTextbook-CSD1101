package chap07_Method;

import java.awt.*;
import java.awt.event.ItemEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class ShapeDrawerSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Shape Drawer - Swing");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DrawingPanel canvas = new DrawingPanel();
            ControlPanel controls = new ControlPanel(canvas);

            f.setLayout(new BorderLayout());
            f.add(controls, BorderLayout.NORTH);
            f.add(canvas, BorderLayout.CENTER);

            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }

    // ==== แผงควบคุม (โหมด/จำนวนด้าน/มุม/ความยาวด้าน) ====
    static class ControlPanel extends JPanel {
        ControlPanel(DrawingPanel canvas) {
            setLayout(new FlowLayout(FlowLayout.LEFT));

            String[] modes = {"Single Polygon", "All Polygons (3–8)", "Rotating Squares"};
            JComboBox<String> modeBox = new JComboBox<>(modes);
            modeBox.setSelectedIndex(0);

            JSpinner nSpinner = new JSpinner(new SpinnerNumberModel(5, 3, 12, 1));
            JSlider angleSlider = new JSlider(0, 359, 0);
            JSlider sideSlider  = new JSlider(20, 180, 120);

            JLabel nLabel = new JLabel("Sides (n):");
            JLabel angleLabel = new JLabel("Angle:");
            JLabel sideLabel = new JLabel("Side d:");

            // แสดงค่าแบบสั้น ๆ
            JLabel angleVal = new JLabel(String.valueOf(angleSlider.getValue()));
            JLabel sideVal  = new JLabel(String.valueOf(sideSlider.getValue()));

            // wire events
            modeBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    canvas.mode = (String) e.getItem();
                    canvas.repaint();
                }
            });

            nSpinner.addChangeListener((ChangeEvent e) -> {
                canvas.n = (Integer) nSpinner.getValue();
                canvas.repaint();
            });

            angleSlider.addChangeListener((ChangeEvent e) -> {
                canvas.angleDeg = angleSlider.getValue();
                angleVal.setText(String.valueOf(canvas.angleDeg));
                canvas.repaint();
            });

            sideSlider.addChangeListener((ChangeEvent e) -> {
                canvas.d = sideSlider.getValue();
                sideVal.setText(String.valueOf(canvas.d));
                canvas.repaint();
            });

            add(new JLabel("Mode:"));
            add(modeBox);
            add(Box.createHorizontalStrut(12));
            add(nLabel); add(nSpinner);
            add(Box.createHorizontalStrut(12));
            add(angleLabel); add(angleSlider); add(angleVal);
            add(Box.createHorizontalStrut(12));
            add(sideLabel); add(sideSlider); add(sideVal);
        }
    }

    // ==== พื้นที่วาดภาพ ====
    static class DrawingPanel extends JPanel {
        String mode = "Single Polygon";
        int n = 5;            // จำนวนด้านของรูปหลายเหลี่ยม
        int angleDeg = 0;     // มุมหมุน (องศา)
        int d = 120;          // ความยาวด้าน

        DrawingPanel() {
            setPreferredSize(new Dimension(500, 500));
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(1.5f));
            g2.setColor(Color.BLACK);

            int xc = getWidth() / 2;
            int yc = getHeight() / 2;

            switch (mode) {
                case "Single Polygon":
                    drawRegularPolygon(g2, xc, yc, d, angleDeg, n);
                    break;

                case "All Polygons (3–8)":
                    // วาดหลายรูปเรียงกันรอบ ๆ ศูนย์
                    int[] ns = {3,4,5,6,7,8};
                    for (int i = 0; i < ns.length; i++) {
                        int rr = 170; // รัศมีจัดวางตำแหน่ง
                        double th = i * (360.0 / ns.length);
                        int px = xc + (int) Math.round(rr * cos(th));
                        int py = yc - (int) Math.round(rr * sin(th));
                        drawRegularPolygon(g2, px, py, 70, angleDeg, ns[i]);
                        String label = ns[i] + "-gon";
                        drawCenterText(g2, label, px, py + 55);
                    }
                    // ตรงกลางวาดห้าเหลี่ยมใหญ่
                    g2.setColor(new Color(0,0,0,200));
                    drawRegularPolygon(g2, xc, yc, d, angleDeg, 5);
                    drawCenterText(g2, "Center: 5-gon", xc, yc + 80);
                    break;

                case "Rotating Squares":
                    // วาดสี่เหลี่ยมหมุนทีละ 10 องศา ตั้งแต่ 0 ถึง 80
                    for (int a = 0; a < 90; a += 10) {
                        float alpha = 0.15f + (a / 100f); // ไล่ความทึบเล็กน้อย
                        alpha = Math.min(alpha, 0.9f);
                        g2.setColor(new Color(0f, 0f, 0f, alpha));
                        drawSquare(g2, xc, yc, d, a + angleDeg);
                    }
                    break;
            }
            g2.dispose();
        }

        // วาดตัวอักษรตรงกลางตำแหน่ง
        private void drawCenterText(Graphics2D g2, String s, int x, int y) {
            FontMetrics fm = g2.getFontMetrics();
            int w = fm.stringWidth(s);
            g2.drawString(s, x - w/2, y);
        }
    }

    // ==== ฟังก์ชันคณิตศาสตร์ (องศา) ====
    static double sin(double deg) { return Math.sin(Math.toRadians(deg)); }
    static double cos(double deg) { return Math.cos(Math.toRadians(deg)); }

    // ==== วาดสี่เหลี่ยมจัตุรัสหมุนรอบ (xc, yc) ด้วยความยาวด้าน d และมุม a (deg) ====
    static void drawSquare(Graphics2D g2, int xc, int yc, int d, int a) {
        double r = d / (2 * cos(45));       // ระยะจากศูนย์ถึงมุมเมื่อเอียง 45°
        double angle = a - 45;

        double x0 = xc + r * cos(angle);
        double y0 = yc - r * sin(angle);

        for (int i = 0; i < 4; i++) {
            angle += 90;
            double x1 = xc + r * cos(angle);
            double y1 = yc - r * sin(angle);
            g2.drawLine((int) Math.round(x0), (int) Math.round(y0),
                    (int) Math.round(x1), (int) Math.round(y1));
            x0 = x1; y0 = y1;
        }
    }

    // ==== วาดรูปหลายเหลี่ยมด้านเท่า (n ด้าน) โดยกำหนดความยาวด้าน d และหมุน a องศา ====
    static void drawRegularPolygon(Graphics2D g2, int xc, int yc, int d, int a, int n) {
        if (n < 3) return;
        double b = (180 - 360.0 / n) / 2.0;   // ครึ่งมุมยอด
        double r = d / (2 * cos(b));          // รัศมีวงกลมล้อมรอบ (circumradius)
        double angle = a - b;

        int x0 = (int) Math.round(xc + r * cos(angle));
        int y0 = (int) Math.round(yc - r * sin(angle));

        for (int i = 0; i < n; i++) {
            angle += 360.0 / n;
            int x1 = (int) Math.round(xc + r * cos(angle));
            int y1 = (int) Math.round(yc - r * sin(angle));
            g2.drawLine(x0, y0, x1, y1);
            x0 = x1; y0 = y1;
        }
    }
}
