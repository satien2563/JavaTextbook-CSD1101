package chap07_Method;

public class Ex7_7c_MaxPriceProductArray {
    // เมธอดหาตำแหน่งของราคาสูงสุดในอาร์เรย์
    public static int indexOfMax(double[] prices) {
        if (prices == null || prices.length == 0) {
            return -1; // กรณีพิเศษ ไม่มีข้อมูล
        }
        int maxIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        String[] products = {"หนังสือ Java", "กระเป๋า", "รองเท้า", "หูฟัง"};
        double[] prices  = {350.0, 1200.0, 950.0, 1490.0};

        int maxIdx = indexOfMax(prices);

        if (maxIdx == -1) {
            System.out.println("ไม่มีข้อมูลสินค้า");
        } else {
            System.out.println("สินค้าที่แพงที่สุด: " + products[maxIdx]);
            System.out.println("ราคา: " + prices[maxIdx] + " บาท");
        }
    }
}
