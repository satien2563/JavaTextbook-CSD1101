package chap03_io;

public class StringFormatExample {
    public static void main(String[] args) {
        String product = "หนังสือ";
        int quantity = 3;
        double price = 125.50;

        String message = String.format("สินค้า: %s | จำนวน: %d | ราคา: %.2f บาท", product, quantity, price);
        System.out.println(message);
    }
}
