package chap07_Method;

public class Ex7_3h_AreaCalculator {
    // คำนวณพื้นที่สี่เหลี่ยมผืนผ้า
    public static double calculateArea(double width, double height) {
        return width * height;
    }

    // คำนวณพื้นที่วงกลม
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // คำนวณพื้นที่สามเหลี่ยม
    public static double calculateArea(double base, double height, boolean isTriangle) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        System.out.println("พื้นที่สี่เหลี่ยมผืนผ้า (4 x 5): " + calculateArea(4, 5));
        System.out.println("พื้นที่วงกลม (รัศมี 3): " + calculateArea(3));
        System.out.println("พื้นที่สามเหลี่ยม (ฐาน 6, สูง 8): " + calculateArea(6, 8, true));
    }
}
