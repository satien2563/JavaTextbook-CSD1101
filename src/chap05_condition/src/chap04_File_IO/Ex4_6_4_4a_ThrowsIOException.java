package chap04_File_IO;

// ตัวอย่างการใช้ throws ส่งต่อข้อยกเว้น
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex4_6_4_4a_ThrowsIOException {
    public static void main(String[] args) {
        try {
            readFile("src/chap04_File_IO/student2.txt");
        } catch (IOException e) {
            System.out.println("เกิดข้อยกเว้น: " + e.getMessage());
        }
    }

    // ประกาศส่งต่อข้อยกเว้น IOException
    public static void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
