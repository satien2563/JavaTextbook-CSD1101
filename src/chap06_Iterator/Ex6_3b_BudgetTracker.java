package chap06_Iterator;

import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex6_3b_BudgetTracker {
    // โครงสร้างข้อมูลรายการรายจ่าย
    static class Item {
        String name;
        double amount;
        Item(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Item> items = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n=== Budget Tracker ===");
            System.out.println("1) เพิ่มรายการรายจ่าย");
            System.out.println("2) แสดงสรุปรายการและยอดรวม");
            System.out.println("3) บันทึกใบเสร็จลงไฟล์และออก");
            System.out.print("เลือกเมนู: ");
            while (!sc.hasNextInt()) { // ป้องกันอินพุตไม่ใช่ตัวเลข
                System.out.print("กรุณากรอกเลขเมนูอีกครั้ง: ");
                sc.next(); // ทิ้งอินพุตเดิม
            }
            choice = sc.nextInt();
            sc.nextLine(); // เคลียร์บรรทัด

            if (choice == 1) {
                System.out.print("ชื่อรายการ: ");
                String name = sc.nextLine().trim();
                double amount = 0;
                boolean valid;
                do {
                    System.out.print("จำนวนเงิน (บาท): ");
                    if (sc.hasNextDouble()) {
                        amount = sc.nextDouble();
                        valid = amount >= 0;
                        if (!valid) System.out.println("จำนวนเงินต้องไม่ติดลบ");
                    } else {
                        System.out.println("กรุณากรอกเป็นตัวเลข");
                        valid = false;
                    }
                    sc.nextLine(); // เคลียร์บรรทัด
                } while (!valid);
                items.add(new Item(name, amount));
                System.out.println("เพิ่มรายการสำเร็จ");
            } else if (choice == 2) {
                printSummary(items);
            } else if (choice == 3) {
                saveReceiptAndExit(items);
            } else {
                System.out.println("เมนูไม่ถูกต้อง");
            }

        } while (choice != 3);
    }

    private static void printSummary(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("ยังไม่มีรายการ");
            return;
        }
        double total = 0;
        System.out.println("\n--- สรุปรายจ่าย ---");
        for (int i = 0; i < items.size(); i++) {
            Item it = items.get(i);
            System.out.printf("%d) %s : %.2f บาท%n", i + 1, it.name, it.amount);
            total += it.amount;
        }
        System.out.printf("ยอดรวมทั้งหมด: %.2f บาท%n", total);
    }

    private static void saveReceiptAndExit(List<Item> items) {
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String fileName = "receipt_" + ts + ".txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.println("ใบเสร็จ Budget Tracker");
            pw.println("วันที่เวลา: " + LocalDateTime.now());
            pw.println("---------------------------");
            double total = 0;
            for (Item it : items) {
                pw.printf("%s : %.2f บาท%n", it.name, it.amount);
                total += it.amount;
            }
            pw.println("---------------------------");
            pw.printf("ยอดรวมทั้งหมด: %.2f บาท%n", total);
            System.out.println("บันทึกไฟล์ใบเสร็จแล้วที่: " + fileName);
            System.out.println("จบการทำงาน");
        } catch (IOException e) {
            System.out.println("บันทึกไฟล์ไม่สำเร็จ: " + e.getMessage());
        }
    }
}
