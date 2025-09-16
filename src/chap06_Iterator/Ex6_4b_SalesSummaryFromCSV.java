package chap06_Iterator;

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex6_4b_SalesSummaryFromCSV {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ขอชื่อไฟล์อินพุต
        System.out.print("ระบุชื่อไฟล์ CSV (เช่น sales.csv): ");
        String path = sc.nextLine().trim();

        // ขอค่าเป้าหมายยอดขาย
        System.out.print("ระบุเป้าหมายยอดขายต่อวัน (บาท): ");
        double target = readNonNegativeDouble(sc);

        List<String> dates = new ArrayList<>();
        List<Double> amounts = new ArrayList<>();

        // --- อ่านไฟล์ CSV ---
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;                  // ข้ามบรรทัดว่าง
                String[] parts = line.split(",");
                if (parts.length != 2) continue;               // ข้ามบรรทัดที่รูปแบบไม่ถูกต้อง

                String date = parts[0].trim();
                try {
                    double amount = Double.parseDouble(parts[1].trim());
                    if (amount < 0) continue;                  // ข้ามค่าติดลบ
                    dates.add(date);
                    amounts.add(amount);
                } catch (NumberFormatException ignore) {
                    // ข้ามบรรทัดที่ยอดขายไม่ใช่ตัวเลข
                }
            }
        } catch (IOException e) {
            System.out.println("ไม่สามารถอ่านไฟล์: " + e.getMessage());
            return;
        }

        if (amounts.isEmpty()) {
            System.out.println("ไม่พบข้อมูลที่ถูกต้องในไฟล์");
            return;
        }

        // --- ใช้ for เพื่อคำนวณสถิติหลัก ---
        double sum = 0.0;
        double min = Double.MAX_VALUE, max = -Double.MAX_VALUE;
        int minIdx = -1, maxIdx = -1;
        int aboveTargetCount = 0;
        List<Integer> aboveIdx = new ArrayList<>();

        for (int i = 0; i < amounts.size(); i++) {
            double v = amounts.get(i);
            sum += v;

            if (v < min) { min = v; minIdx = i; }            // หาค่าต่ำสุด
            if (v > max) { max = v; maxIdx = i; }            // หาค่าสูงสุด

            if (v >= target) {                               // เกินหรือเท่ากับเป้าหมาย
                aboveTargetCount++;
                aboveIdx.add(i);
            }
        }
        double avg = sum / amounts.size();

        // --- เขียนสรุปลงไฟล์ ---
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String outName = "sales_summary_" + ts + ".txt";

        try (PrintWriter out = new PrintWriter(new FileWriter(outName))) {
            out.println("สรุปยอดขายจากไฟล์: " + path);
            out.println("จำนวนวันที่บันทึกได้: " + amounts.size());
            out.printf("ยอดรวมทั้งหมด: %.2f บาท%n", sum);
            out.printf("ค่าเฉลี่ยต่อวัน: %.2f บาท%n", avg);
            out.printf("ค่าสูงสุด: %.2f บาท (%s)%n", max, dates.get(maxIdx));
            out.printf("ค่าต่ำสุด: %.2f บาท (%s)%n", min, dates.get(minIdx));
            out.printf("จำนวนวันที่ยอด >= เป้า(%.2f): %d วัน%n", target, aboveTargetCount);
            out.println("รายการวันที่ถึง/เกินเป้า:");
            for (int j = 0; j < aboveIdx.size(); j++) {      // ใช้ for เพื่อไล่พิมพ์วันที่ที่เกินเป้า
                int i = aboveIdx.get(j);
                out.printf("- %s : %.2f บาท%n", dates.get(i), amounts.get(i));
            }
        } catch (IOException e) {
            System.out.println("เขียนไฟล์สรุปไม่สำเร็จ: " + e.getMessage());
            return;
        }

        System.out.println("สร้างไฟล์สรุปแล้ว: " + outName);
    }

    // ---------- helper ----------
    private static double readNonNegativeDouble(Scanner sc) {
        while (true) {
            if (sc.hasNextDouble()) {
                double v = sc.nextDouble();
                sc.nextLine();
                if (v >= 0) return v;
            } else sc.next();
            System.out.print("กรุณากรอกจำนวนจริงศูนย์ขึ้นไป: ");
        }
    }
}

