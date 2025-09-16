package chap06_Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex6_5c_ProductTargetReport {

    // โครงสร้างข้อมูลสินค้า
    static class Product {
        String name;
        int unitsSold;
        int target;
        Product(String name, int unitsSold, int target) {
            this.name = name;
            this.unitsSold = unitsSold;
            this.target = target;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // รับชื่อไฟล์อินพุตและตรวจสอบเบื้องต้น
        System.out.print("ระบุชื่อไฟล์ CSV (เช่น products.csv): ");
        String csvPath = sc.nextLine().trim();

        // อ่านข้อมูลสินค้าเข้า List<Product>
        List<Product> products = readProductsFromCSV(csvPath);
        if (products.isEmpty()) {
            System.out.println("ไม่พบข้อมูลที่ถูกต้องในไฟล์");
            return;
        }

        // --- ใช้ for-each เพื่อคัดกรองและสรุปผล ---
        List<Product> achieved = new ArrayList<>();
        int total = 0;
        for (Product p : products) {                   // for-each เดินผ่านสินค้าทุกตัว
            total++;
            if (p.unitsSold >= p.target) {             // ใช้ if ตรวจเงื่อนไขถึงเป้าหมาย
                achieved.add(p);
            }
        }

        // เขียนรายงานลงไฟล์พร้อม timestamp
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String reportName = "product_target_report_" + ts + ".txt";

        try (PrintWriter out = new PrintWriter(new FileWriter(reportName))) {
            out.println("รายงานสินค้าเกินหรือเท่ากับเป้าการขาย");
            out.println("จำนวนสินค้าทั้งหมด: " + total);
            out.println("จำนวนที่ถึง/เกินเป้า: " + achieved.size());
            out.println("---------------------------------------");

            // แสดงเฉพาะรายการที่ถึงเป้า ใช้ for-each เพื่อพิมพ์บรรทัดรายงาน
            for (Product p : achieved) {
                int diff = p.unitsSold - p.target;
                out.printf("%s | ขายได้=%d | เป้า=%d | ส่วนต่าง=+%d%n",
                        p.name, p.unitsSold, p.target, diff);
            }
        } catch (IOException e) {
            System.out.println("เขียนไฟล์รายงานไม่สำเร็จ: " + e.getMessage());
            return;
        }

        System.out.println("สร้างไฟล์รายงานแล้ว: " + reportName);
    }

    // ---------- อ่าน CSV เป็นรายการสินค้า ----------
    private static List<Product> readProductsFromCSV(String path) {
        List<Product> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;           // ข้ามบรรทัดว่าง
                String[] parts = line.split(",");
                if (parts.length != 3) continue;        // รูปแบบไม่ถูกต้องให้ข้าม

                String name = parts[0].trim();
                try {
                    int sold = Integer.parseInt(parts[1].trim());
                    int target = Integer.parseInt(parts[2].trim());
                    if (sold < 0 || target < 0 || name.isEmpty()) continue; // ตรวจค่าผิดปกติ
                    list.add(new Product(name, sold, target));
                } catch (NumberFormatException ignore) {
                    // ข้ามบรรทัดที่ยอดขาย/เป้าไม่ใช่ตัวเลข
                }
            }
        } catch (IOException e) {
            System.out.println("ไม่สามารถอ่านไฟล์ CSV ได้: " + e.getMessage());
        }
        return list;
    }
}
