package chap04_File_IO;

// ตัวอย่างที่ 4.3.2e: โปรแกรมบันทึกความคิดเห็นของลูกค้าด้วย Files.write()

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Ex4_3_2e_FilesWrite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("กรุณากรอกชื่อแฟ้มที่ต้องการบันทึก (เช่น feedback.txt): ");
        String filename = scanner.nextLine();

        List<String> lines = new ArrayList<>();
        System.out.println("พิมพ์ความคิดเห็นทีละบรรทัด (พิมพ์ 'exit' เพื่อหยุด)");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            lines.add(input);
        }

        try {
            Files.write(
                    Paths.get("src/chap04_File_IO/" + filename),
                    lines,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            System.out.println("บันทึกความคิดเห็นลงแฟ้มเรียบร้อยแล้ว");
        } catch (IOException e) {
            System.out.println("เกิดข้อผิดพลาด: " + e.getMessage());
        }

        scanner.close();
    }
}
