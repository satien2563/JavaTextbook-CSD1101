package chap04_File_IO;

// ตัวอย่างการใช้ try-catch ดักจับ ArithmeticException
public class Ex4_6_4_1a_TryCatchArithmetic {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int result = a / b; // อาจเกิด ArithmeticException
            System.out.println("ผลลัพธ์: " + result);
        } catch (ArithmeticException e) {
            System.out.println("เกิดข้อยกเว้น: ไม่สามารถหารด้วยศูนย์ได้");
        }
        System.out.println("โปรแกรมทำงานต่อได้");
    }
}