package chap04_File_IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SetupCh4SampleFiles {
    public static void main(String[] args) {
        String basePath = "src/chap04_File_IO/";

        // สร้างไฟล์ตัวอย่าง
        createFile(basePath + "students.txt",
                "อนันต์\nวิภา\nจิราพร\nสมชาย\nรุ่งนภา\n");

        createFile(basePath + "products.txt",
                "ดินสอ,5.50\nปากกา,12.00\nสมุดโน้ต,25.00\nแฟ้มเอกสาร,45.00\n" +
                        "กระดาษ A4,200.00\nหมึกปริ้นเตอร์,300.00\nแฟลชไดรฟ์,250.00\n");

        createFile(basePath + "diary.txt",
                "[2025-08-01 09:00] เริ่มต้นเขียนบันทึกประจำวัน\n" +
                        "[2025-08-02 20:15] วันนี้ฝนตกทั้งวัน\n");

        createFile(basePath + "note.txt",
                "การเขียนโปรแกรมเป็นทักษะที่ต้องฝึกฝน\n" +
                        "การใช้ภาษา Java ช่วยให้เข้าใจแนวคิด OOP\n" +
                        "การจัดการแฟ้มข้อมูลและข้อยกเว้นเป็นหัวใจสำคัญของโปรแกรมที่ดี\n");

        createFile(basePath + "part1.txt",
                "นี่คือเนื้อหาส่วนแรกของเอกสาร\n" +
                        "สามารถต่อเนื่องกับข้อมูลส่วนที่สอง\n");

        createFile(basePath + "part2.txt",
                "นี่คือเนื้อหาส่วนที่สองของเอกสาร\n" +
                        "ทำให้ข้อมูลสมบูรณ์เมื่อรวมกับส่วนแรก\n");

        createFile(basePath + "grades.txt",
                "อนันต์,78\nวิภา,92\nจิราพร,85\nสมชาย,60\nรุ่งนภา,45\n");

        // สร้างโฟลเดอร์ data สำหรับข้อ 10
        File dataDir = new File(basePath + "data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
            System.out.println("สร้างโฟลเดอร์ data แล้ว");
        }

        createFile(basePath + "data/data1.txt",
                "ข้อมูลไฟล์ที่ 1\nใช้สำหรับทดสอบการสำรองข้อมูล\n");

        createFile(basePath + "data/data2.txt",
                "ข้อมูลไฟล์ที่ 2\nใช้สำหรับทดสอบการสำรองข้อมูล\n");

        System.out.println("สร้างไฟล์ตัวอย่างบทที่ 4 เรียบร้อยแล้ว");
    }

    // เมธอดสำหรับสร้างไฟล์พร้อมเนื้อหา
    private static void createFile(String filePath, String content) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.print(content);
            System.out.println("สร้างไฟล์: " + filePath);
        } catch (IOException e) {
            System.out.println("เกิดข้อผิดพลาดในการสร้างไฟล์: " + filePath);
            e.printStackTrace();
        }
    }
}
