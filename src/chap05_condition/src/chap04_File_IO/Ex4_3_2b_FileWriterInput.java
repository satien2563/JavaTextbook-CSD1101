package chap04_File_IO;

// ตัวอย่างที่ 4.3.2b: การรับข้อมูลจากผู้ใช้และเขียนลงแฟ้มด้วย FileWriter

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex4_3_2b_FileWriterInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // รับชื่อแฟ้มจากผู้ใช้
        System.out.print("กรุณากรอกชื่อแฟ้มที่ต้องการบันทึก (เช่น student.txt): ");
        String filename = input.nextLine();

        // รับข้อมูลนักศึกษา
        System.out.print("กรุณากรอกชื่อนักศึกษา: ");
        String name = input.nextLine();

        System.out.print("กรุณากรอกเกรดเฉลี่ย: ");
        double gpa = input.nextDouble();

        // เขียนข้อมูลลงแฟ้ม
        try {
            FileWriter writer = new FileWriter("src/chap04_file_IO/"+ filename, true); // เขียนต่อท้ายไฟล์

            writer.write("ชื่อ: " + name + "\n");
            writer.write("เกรดเฉลี่ย: " + gpa + "\n");
            writer.write("-------------------------\n");

            writer.close();
            System.out.println("บันทึกข้อมูลลงแฟ้ม \"" + filename + "\" เรียบร้อยแล้ว");
        } catch (IOException e) {
            System.out.println("เกิดข้อผิดพลาด: " + e.getMessage());
        }

        input.close();
    }
}
