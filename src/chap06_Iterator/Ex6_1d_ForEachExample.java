package chap06_Iterator;

public class Ex6_1d_ForEachExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.println("ค่าของ num คือ " + num);
        }
    }
}
