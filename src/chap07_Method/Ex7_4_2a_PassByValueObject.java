package chap07_Method;

class Student {
    String name;
}

public class Ex7_4_2a_PassByValueObject {
    // เมธอดเปลี่ยนชื่อของนักศึกษา
    public static void changeName(Student s) {
        s.name = "สมชาย";  // แก้ไขคุณสมบัติของอ็อบเจกต์
    }

    public static void main(String[] args) {
        Student st = new Student();
        st.name = "สมหญิง";

        changeName(st); // ส่งอ็อบเจกต์เข้าเมธอด
        System.out.println("ชื่อนักศึกษา: " + st.name);
    }
}
