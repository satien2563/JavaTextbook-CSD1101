package chap07_Method;

public class Ex7_3b_EvenOddChecker {
    // เมธอดที่คืนค่าข้อความว่าเลขที่ส่งเข้ามาเป็นเลขคู่หรือเลขคี่
    public static String checkEvenOdd(int number) {
        if (number % 2 == 0) {
            return "เลขคู่";
        } else {
            return "เลขคี่";
        }
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 15;

        System.out.println(num1 + " เป็น " + checkEvenOdd(num1));
        System.out.println(num2 + " เป็น " + checkEvenOdd(num2));
    }
}
