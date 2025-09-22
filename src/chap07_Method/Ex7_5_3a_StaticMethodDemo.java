package chap07_Method;

class MathUtil {
    // ค่าคงที่ PI
    public static final double PI = 3.14159;

    // เมธอดแบบสแตติกสำหรับคำนวณพื้นที่วงกลม
    public static double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }

    // เมธอดแบบสแตติกสำหรับคำนวณกำลังสอง
    public static int square(int number) {
        return number * number;
    }
}

public class Ex7_5_3a_StaticMethodDemo {
    public static void main(String[] args) {
        // เรียกใช้เมธอดแบบสแตติกโดยไม่ต้องสร้างอ็อบเจกต์
        double area = MathUtil.calculateCircleArea(5);
        int result = MathUtil.square(7);

        System.out.println("พื้นที่วงกลมรัศมี 5 คือ " + area);
        System.out.println("7 ยกกำลังสองคือ " + result);
    }
}
