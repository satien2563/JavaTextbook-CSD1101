package chap03_io;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerFromFile {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("src/chap03_io/student.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println("ข้อมูล: " + line);
            }
            input.close();
        } catch (IOException e) {
            System.out.println("เกิดข้อผิดพลาดในการเปิดไฟล์");
        }
    }
}

