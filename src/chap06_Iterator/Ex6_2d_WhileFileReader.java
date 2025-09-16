package chap06_Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex6_2d_WhileFileReader {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/chap06_Iterator/data.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("เกิดข้อผิดพลาดในการอ่านไฟล์");
        }
    }
}
