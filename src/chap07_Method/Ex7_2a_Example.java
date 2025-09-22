package chap07_Method;

public class Ex7_2a_Example {
    // เมธอดสำหรับบวกเลขจำนวนเต็มสองจำนวน
    public static int add(int x, int y) {
        int sum = x + y;   // ส่วนของ body
        return sum;        // ส่งค่ากลับ
    }

    public static void main(String[] args) {
        System.out.println("ผลบวกของ 5 และ 3 คือ " + add(5, 3));
    }
}
