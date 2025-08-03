package chap04_File_IO;

// ตัวอย่างที่ 4.4.4a: อ่านไฟล์ด้วย Files.lines() และแสดงผลทุกบรรทัด
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.Scanner;

public class Ex4_4_4a_FilesLinesStream {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("กรุณาป้อนชื่อแฟ้ม: ");
        String filename = console.nextLine();

        try (Stream<String> lines = Files.lines(Paths.get("src/chap04_File_IO/" + filename))) {
            System.out.println("----- ข้อมูลในแฟ้ม -----");
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("เกิดข้อผิดพลาด: " + e.getMessage());
        }

        console.close();
    }
}
