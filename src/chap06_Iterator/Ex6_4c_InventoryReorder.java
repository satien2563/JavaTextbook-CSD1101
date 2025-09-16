package chap06_Iterator;

import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex6_4c_InventoryReorder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("กรอกจำนวนสินค้าที่ต้องการประมวลผล: ");
        int n = readPositiveInt(sc);

        // เก็บข้อมูลเพื่อสรุปรายงาน
        List<String> reportLines = new ArrayList<>();
        double totalCost = 0.0;
        int reorderCount = 0;

        // --- ใช้ for เพื่ออ่านข้อมูลสินค้าทีละรายการ ---
        for (int i = 1; i <= n; i++) {
            System.out.println("\nรายการที่ " + i);

            System.out.print("ชื่อสินค้า: ");
            String name = sc.nextLine().trim();
            while (name.isEmpty()) {                     // ตรวจสอบความว่างของชื่อ
                System.out.print("ชื่อสินค้าห้ามว่าง กรอกใหม่: ");
                name = sc.nextLine().trim();
            }

            System.out.print("จำนวนคงเหลือ: ");
            int stock = readNonNegativeInt(sc);

            System.out.print("ขั้นต่ำที่ต้องมี (Reorder Point): ");
            int minStock = readNonNegativeInt(sc);

            System.out.print("ราคาต่อหน่วย (บาท): ");
            double price = readNonNegativeDouble(sc);

            // --- เงื่อนไขตัดสินใจว่าต้องสั่งซื้อซ้ำหรือไม่ ---
            if (stock < minStock) {
                int need = minStock - stock;             // ปริมาณที่ต้องสั่งเพิ่ม
                double cost = need * price;              // มูลค่าที่ต้องสั่งเพิ่ม
                totalCost += cost;
                reorderCount++;

                // บรรทัดสรุปสำหรับรายงาน
                reportLines.add(String.format(
                        "[REORDER] %s | คงเหลือ=%d | ขั้นต่ำ=%d | ต้องสั่งเพิ่ม=%d | ราคา=%.2f | มูลค่า=%.2f",
                        name, stock, minStock, need, price, cost));
            } else {
                reportLines.add(String.format(
                        "[OK]      %s | คงเหลือ=%d | ขั้นต่ำ=%d | ไม่ต้องสั่งเพิ่ม",
                        name, stock, minStock));
            }
        }

        // --- บันทึกไฟล์ใบสั่งซื้อเบื้องต้น ---
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = "purchase_order_" + ts + ".txt";

        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.println("ใบสั่งซื้อเบื้องต้น (Draft Purchase Order)");
            out.println("วันที่เวลา: " + LocalDateTime.now());
            out.println("------------------------------------------------------------");
            for (int i = 0; i < reportLines.size(); i++) {      // ใช้ for เพื่อพิมพ์บรรทัดรายงานทีละบรรทัด
                out.printf("%2d) %s%n", i + 1, reportLines.get(i));
            }
            out.println("------------------------------------------------------------");
            out.printf("จำนวนรายการที่ต้องสั่งซื้อซ้ำ: %d%n", reorderCount);
            out.printf("มูลค่ารวมที่ต้องสั่งซื้อ: %.2f บาท%n", totalCost);
        } catch (IOException e) {
            System.out.println("บันทึกไฟล์ไม่สำเร็จ: " + e.getMessage());
            return;
        }

        System.out.println("\nสร้างไฟล์ใบสั่งซื้อแล้ว: " + fileName);
        System.out.println("เสร็จสิ้นการประมวลผล");
    }

    // ----------------- Helpers สำหรับอ่านอินพุตพร้อมตรวจสอบ -----------------

    // อ่านจำนวนเต็มบวก
    private static int readPositiveInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int v = sc.nextInt();
                sc.nextLine(); // เคลียร์บรรทัด
                if (v > 0) return v;
            } else sc.next();  // ทิ้งอินพุตที่ไม่ใช่ตัวเลข
            System.out.print("กรุณากรอกจำนวนเต็มบวก: ");
        }
    }

    // อ่านจำนวนเต็มศูนย์ขึ้นไป
    private static int readNonNegativeInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int v = sc.nextInt();
                sc.nextLine();
                if (v >= 0) return v;
            } else sc.next();
            System.out.print("กรุณากรอกจำนวนเต็มศูนย์ขึ้นไป: ");
        }
    }

    // อ่านจำนวนจริงศูนย์ขึ้นไป
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
