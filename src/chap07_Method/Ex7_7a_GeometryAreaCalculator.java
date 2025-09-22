package chap07_Method;

public class Ex7_7a_GeometryAreaCalculator {
    public static double rectangleArea(double width, double height) {
        return width * height;
    }

    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double triangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        System.out.println("พื้นที่สี่เหลี่ยมผืนผ้า: " + rectangleArea(5, 10));
        System.out.println("พื้นที่วงกลม: " + circleArea(7));
        System.out.println("พื้นที่สามเหลี่ยม: " + triangleArea(6, 8));
    }
}
