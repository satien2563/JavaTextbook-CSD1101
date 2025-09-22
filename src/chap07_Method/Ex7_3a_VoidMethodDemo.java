package chap07_Method;

public class Ex7_3a_VoidMethodDemo {
    // เมธอดแบบ void สำหรับแสดงข้อความ
    public static void printMessage(String msg) {
        System.out.println("ข้อความที่ได้รับ: " + msg);
    }

    public static void main(String[] args) {
        printMessage("สวัสดี เมธอดแบบ void");
    }
}
