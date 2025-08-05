package chap04_File_IO;

// ตัวอย่างการใช้ try-catch-finally ปิดไฟล์หลังใช้งาน
import java.io.FileReader;
import java.io.IOException;

public class Ex4_6_4_2a_TryCatchFinallyFile {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("src/chap04_File_IO/student2.txt");
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println("เกิดข้อยกเว้น: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("\nปิดไฟล์เรียบร้อยแล้ว");
                }
            } catch (IOException e) {
                System.out.println("ไม่สามารถปิดไฟล์ได้: " + e.getMessage());
            }
        }
    }
}

