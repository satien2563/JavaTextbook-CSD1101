package chap07_Method;

public class Ex7_3e_GradeCalculator {
    // เมธอดคำนวณเกรดจากคะแนนและคืนค่าเป็นตัวอักษร
    public static String calculateGrade(int score) {
        if (score >= 80) {
            return "A";
        } else if (score >= 70) {
            return "B";
        } else if (score >= 60) {
            return "C";
        } else if (score >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        int score = 75;
        String grade = calculateGrade(score);  // เรียกใช้เมธอดคำนวณเกรด
        System.out.println("คะแนน: " + score + " ได้เกรด: " + grade);
    }

}
