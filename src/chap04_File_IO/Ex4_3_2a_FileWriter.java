package chap04_File_IO;

// ตัวอย่างที่ 4.3.2a: การเขียนข้อมูลนักศึกษาลงแฟ้มด้วย FileWriter

import java.io.FileWriter;
import java.io.IOException;

public class Ex4_3_2a_FileWriter {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("src/chap04_File_IO/output.txt", true); // เขียนต่อท้ายไฟล์
            writer.write("=== ข้อมูลนักศึกษา ===\n");
            writer.write("ชื่อ: นางสาวศิริพร อินทร์ดี\n");
            writer.write("รหัสประจำตัว: 65309010001\n");
            writer.write("สาขาวิชา: วิทยาการคอมพิวเตอร์\n");
            writer.write("เกรดเฉลี่ย: 3.75\n");
            writer.write("-------------------------\n");
            writer.close();
            System.out.println("เขียนไฟล์เรียบร้อยแล้ว");
        } catch (IOException e) {
            System.out.println("เกิดข้อผิดพลาด: " + e.getMessage());
        }
    }
}
