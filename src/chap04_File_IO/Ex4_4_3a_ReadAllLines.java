package chap04_File_IO;

// ตัวอย่างที่ 4.4.3a: การอ่านไฟล์ทั้งหมดด้วย Files.readAllLines()
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Ex4_4_3a_ReadAllLines {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("กรุณาป้อนชื่อแฟ้ม: ");
        String filename = console.nextLine();

        try {
            Path path = Paths.get("src/chap04_File_IO/" + filename);
            List<String> lines = Files.readAllLines(path);

            System.out.println("----- ข้อมูลในแฟ้ม -----");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("เกิดข้อผิดพลาด: " + e.getMessage());
        }

        console.close();
    }
}
