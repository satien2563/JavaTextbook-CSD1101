package chap04_File_IO;

// ตัวอย่างที่ 4.3.2c: โปรแกรมบันทึกข้อความลงแฟ้มด้วย BufferedWriter

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex4_3_2c_BufferedWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับชื่อแฟ้มจากผู้ใช้
        System.out.print("กรุณากรอกชื่อแฟ้มที่ต้องการบันทึก (เช่น note.txt): ");
        String filename = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/chap04_File_IO/" + filename, true))) {
            System.out.println("พิมพ์ข้อความทีละบรรทัด (พิมพ์ 'exit' เพื่อจบการบันทึก):");

            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("exit")) break;
                writer.write(line);
                writer.newLine();
            }

            System.out.println("บันทึกข้อความลงแฟ้มเรียบร้อยแล้ว");
        } catch (IOException e) {
            System.out.println("เกิดข้อผิดพลาดในการเขียนไฟล์: " + e.getMessage());
        }

        scanner.close();
    }
}