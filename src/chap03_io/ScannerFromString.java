package chap03_io;

import java.util.Scanner;

public class ScannerFromString {
    public static void main(String[] args) {
        String data = "CSD1101 3.50";
        Scanner input = new Scanner(data);

        String courseCode = input.next();
        double gpa = input.nextDouble();

        System.out.println("รหัสวิชา: " + courseCode);
        System.out.println("เกรดเฉลี่ย: " + gpa);
    }
}
