package chap07_Method;

public class Ex7_4_1a_PassByValuePrimitive {
    // เมธอดเพิ่มค่าตัวเลขขึ้น 1
    public static void increment(int x) {
        x = x + 1;
        System.out.println("ค่าภายในเมธอด: " + x);
    }

    public static void main(String[] args) {
        int number = 5;
        increment(number); // ส่งตัวแปร number เข้าเมธอด
        System.out.println("ค่าตัวแปรต้นฉบับ: " + number);
    }
}
