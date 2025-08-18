package chap03_io;

public class PrintfExample {
    public static void main(String[] args) {
        String name = "ธนภัทร";
        int age = 20;
        double gpa = 3.75;

        System.out.printf("ชื่อนักศึกษา: %s\n", name);
        System.out.printf("อายุ: %d ปี\n", age);
        System.out.printf("เกรดเฉลี่ย: %.2f\n", gpa);
    }
}
