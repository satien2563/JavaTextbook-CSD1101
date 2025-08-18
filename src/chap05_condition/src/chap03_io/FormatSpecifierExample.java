package chap03_io;

public class FormatSpecifierExample {
    public static void main(String[] args) {
        int studentId = 65123456;
        String studentName = "ธนภัทร";
        char grade = 'A';
        double gpa = 3.85;

        System.out.printf("รหัสนักศึกษา: %d\n", studentId);
        System.out.printf("ชื่อนักศึกษา: %s\n", studentName);
        System.out.printf("เกรด: %c\n", grade);
        System.out.printf("เกรดเฉลี่ย: %.2f\n", gpa);
    }
}
