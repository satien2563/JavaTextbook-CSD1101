package chap07_Method;

public class Ex7_4_3b_ArrayModifyDemo {
    // เมธอดเพิ่มคะแนนทุกตัวในอาร์เรย์ขึ้น 5 คะแนน
    public static void applyBonus(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += 5;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 75, 80};

        System.out.println("ก่อนปรับโบนัส:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();

        applyBonus(scores); // เรียกเมธอดเพื่อแก้ไขค่าในอาร์เรย์

        System.out.println("หลังปรับโบนัส:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}
