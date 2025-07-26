package chap03_io;

public class PrintlnExample1 {
    public static void main(String[] args) {
        // ประกาศตัวแปรข้อมูลนักศึกษา
        String id = "65123456";
        String name = "ธนภัทร";
        int age = 20;

        // แสดงผลข้อมูลนักศึกษา
        System.out.println("รหัสนักศึกษา: " + id);
        System.out.println("ชื่อนักศึกษา: " + name);
        System.out.println("อายุ: " + age + " ปี");

        // แสดงผลข้อมูลรายวิชา
        System.out.println("ชื่อวิชา: การโปรแกรมคอมพิวเตอร์");
        System.out.println("รหัสวิชา: CSD1101");
        System.out.println("ระดับ: ปริญญาตรี");
        System.out.println("ภาคเรียน: 1/2568");
    }
}
