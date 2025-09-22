package chap07_Method;

public class Ex7_3f_StudentGradeReport {
    // เมธอดคำนวณเกรดจากคะแนน
    public static String calculateGrade(int score) {
        if (score >= 80) return "A";
        else if (score >= 70) return "B";
        else if (score >= 60) return "C";
        else if (score >= 50) return "D";
        else return "F";
    }

    // เมธอดตรวจสอบว่าสอบผ่านหรือไม่
    public static boolean isPassed(int score) {
        return score >= 50;  // คืนค่า true ถ้าคะแนนมากกว่าหรือเท่ากับ 50
    }

    // เมธอดพิมพ์รายงานผลการเรียน
    public static void printReport(String name, int score) {
        String grade = calculateGrade(score);     // เรียกใช้เมธอดคำนวณเกรด
        boolean passed = isPassed(score);         // เรียกใช้เมธอดตรวจสอบผ่าน/ไม่ผ่าน

        System.out.println("=== รายงานผลการเรียน ===");
        System.out.println("ชื่อนักศึกษา: " + name);
        System.out.println("คะแนน: " + score);
        System.out.println("เกรด: " + grade);
        System.out.println("สถานะ: " + (passed ? "ผ่าน" : "ไม่ผ่าน"));
        System.out.println("========================");
    }

    public static void main(String[] args) {
        // เรียกใช้เมธอด printReport สำหรับนักศึกษา 2 คน
        printReport("สมชาย ใจดี", 82);
        printReport("สมหญิง ตั้งใจ", 45);
    }
}
