package chap04_File_IO;

// ตัวอย่างการใช้ try-with-resources อ่านไฟล์ข้อความ
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex4_6_4_3a_TryWithResourcesFile {
    public static void main(String[] args) {
        String filePath = "src/chap04_File_IO/student.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("เกิดข้อยกเว้น: " + e.getMessage());
        }
    }
}
