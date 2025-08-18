package chap04_File_IO;

// ตัวอย่างที่ 4.4.2a: การอ่านไฟล์ข้อความด้วย BufferedReader
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex4_4_2a_BufferedReaderRead {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("กรุณาป้อนชื่อแฟ้มที่ต้องการอ่าน: ");
        String filename = console.nextLine();

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/chap04_File_IO/" + filename)
            );

            String line;
            System.out.println("----- ข้อมูลในแฟ้ม -----");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("เกิดข้อผิดพลาด: " + e.getMessage());
        }

        console.close();
    }
}
