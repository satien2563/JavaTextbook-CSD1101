package chap04_File_IO;

// ตัวอย่างที่ 4.4.1a: การอ่านไฟล์ข้อความด้วย Scanner และ File
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex4_4_1a_ScannerFileRead {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("กรุณากรอกชื่อแฟ้มที่ต้องการอ่าน: ");
        String filename = console.nextLine();

        try {
            File file = new File("src/chap04_File_IO/" + filename);
            Scanner input = new Scanner(file);

            System.out.println("----- เนื้อหาในแฟ้ม -----");
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("ไม่พบแฟ้ม: " + e.getMessage());
        }

        console.close();
    }
}
