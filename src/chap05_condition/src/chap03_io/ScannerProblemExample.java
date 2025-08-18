package chap03_io;

import java.util.Scanner;

public class ScannerProblemExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("กรอกอายุ: ");
        int age = input.nextInt();  // รับค่าจำนวนเต็ม

        System.out.print("กรอกชื่อ: ");
        String name = input.nextLine();  // จะถูกข้าม ไม่ได้รอให้กรอกชื่อ

        System.out.println("อายุ: " + age);
        System.out.println("ชื่อ: " + name);
    }
}
