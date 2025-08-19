package chap05_conditional;

import java.util.Scanner;

public class Ex5_6a_EventCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //แสดงชื่อโปรแกรม
        System.out.println("โปรแกรมตรวจสอบสิทธิ์เข้าร่วมกิจกรรม");

        //รับค่า อายุ และเป็นนักศึกษาหรือไม่
        System.out.print("กรอกอายุ: ");
        int age = input.nextInt();

        System.out.print("คุณเป็นนักศึกษาใช่หรือไม่ (true/false): ");
        boolean isStudent = input.nextBoolean();

        //ใช้ if เพื่อตรวจสอบเงื่อนไข และ ใช้ && เชื่อมเงื่อนไข
        if (age >= 18 && age <= 30 && isStudent) {
            System.out.println("คุณมีสิทธิ์เข้าร่วมกิจกรรม");
        } else {
            System.out.println("คุณไม่ผ่านเงื่อนไขการเข้าร่วม");
        }

        input.close();
    }
}
