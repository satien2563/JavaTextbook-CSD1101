package chap03_io;

import java.util.Scanner;

public class ScannerFixExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("กรอกอายุ: ");
        int age = input.nextInt();
        input.nextLine();  // อ่าน \n ที่เหลือจากการกด Enter

        System.out.print("กรอกชื่อ: ");
        String name = input.nextLine();

        System.out.println("อายุ: " + age);
        System.out.println("ชื่อ: " + name);
    }
}
