package chap06_Iterator;

import java.util.Scanner;

public class Ex6_2c_WhilePassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = "";
        String correctPassword = "java123";

        while (!password.equals(correctPassword)) {
            System.out.print("กรอกรหัสผ่าน: ");
            password = sc.nextLine();
        }

        System.out.println("เข้าสู่ระบบสำเร็จ!");
    }
}
