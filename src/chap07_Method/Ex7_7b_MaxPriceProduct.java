package chap07_Method;

public class Ex7_7b_MaxPriceProduct {
    // เมธอดหาค่าราคาสูงที่สุด
    public static double findMaxPrice(double p1, double p2, double p3) {
        double max = p1;
        if (p2 > max) {
            max = p2;
        }
        if (p3 > max) {
            max = p3;
        }
        return max;
    }

    public static void main(String[] args) {
        double priceBook = 350.0;
        double priceBag = 1200.0;
        double priceShoes = 950.0;

        double maxPrice = findMaxPrice(priceBook, priceBag, priceShoes);

        System.out.println("ราคาสินค้าที่แพงที่สุดคือ: " + maxPrice + " บาท");
    }
}
