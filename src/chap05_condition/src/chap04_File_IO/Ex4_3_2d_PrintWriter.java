package chap04_File_IO;

// ตัวอย่างที่ 4.3.2d: โปรแกรมบันทึกรายการจองโต๊ะด้วย PrintWriter

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex4_3_2d_PrintWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("กรุณากรอกชื่อแฟ้มที่ต้องการบันทึก (เช่น reservation.txt): ");
        String filename = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/chap04_File_IO/" + filename, true))) {
            System.out.println("ระบบบันทึกรายการจองโต๊ะ (พิมพ์ 'exit' เพื่อหยุด)");

            while (true) {
                System.out.print("ชื่อลูกค้า: ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("exit")) break;

                System.out.print("จำนวนที่จอง: ");
                int seats = Integer.parseInt(scanner.nextLine());

                writer.printf("ลูกค้า: %-20s จำนวนที่นั่ง: %2d\n", name, seats);
            }

            System.out.println("บันทึกรายการจองลงแฟ้มเรียบร้อยแล้ว");

        } catch (IOException e) {
            System.out.println("เกิดข้อผิดพลาด: " + e.getMessage());
        }

        scanner.close();
    }
}
