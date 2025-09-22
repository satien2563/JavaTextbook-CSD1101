package chap07_Method;

public class Ex7_4_3a_ArraySumDemo {
    // เมธอดคำนวณผลรวมจากอาร์เรย์
    public static int calculateSum(int[] numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] scores = {85, 90, 78, 92, 88}; // คะแนนนักศึกษา
        int total = calculateSum(scores);

        System.out.println("ผลรวมคะแนน: " + total);
    }
}
