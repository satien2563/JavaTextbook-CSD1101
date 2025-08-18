package chap04_File_IO;

// ตัวอย่างที่ 4.4.5a: อ่านตัวเลขจากแฟ้มด้วย Scanner และหาค่าเฉลี่ย
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex4_4_5a_ScannerReadNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("กรุณาป้อนชื่อแฟ้มที่มีตัวเลข: ");
        String filename = console.nextLine();

        try {
            File file = new File("src/chap04_File_IO/" + filename);
            Scanner input = new Scanner(file);

            double sum = 0;
            int count = 0;

            while (input.hasNextDouble()) {
                double number = input.nextDouble();
                sum += number;
                count++;
            }

            input.close();

            if (count > 0) {
                double average = sum / count;
                System.out.printf("ค่าเฉลี่ยของตัวเลขทั้งหมด = %.2f\n", average);
            } else {
                System.out.println("ไม่พบข้อมูลตัวเลขในแฟ้ม");
            }

        } catch (FileNotFoundException e) {
            System.out.println("ไม่พบแฟ้มข้อมูล: " + e.getMessage());
        }

        console.close();
    }
}
