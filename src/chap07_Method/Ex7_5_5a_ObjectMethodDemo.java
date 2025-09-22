package chap07_Method;

class Product {
    private String name;
    private double price;

    // คอนสตรัคเตอร์สำหรับกำหนดชื่อและราคา
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // เมธอดคำนวณราคาหลังหักส่วนลด
    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= 100) {
            price -= price * (percent / 100);
        }
    }

    // เมธอดแสดงข้อมูลสินค้า
    public void printInfo() {
        System.out.println("สินค้า: " + name + ", ราคา: " + price + " บาท");
    }
}

public class Ex7_5_5a_ObjectMethodDemo {
    public static void main(String[] args) {
        // สร้างอ็อบเจกต์สินค้า 2 รายการ
        Product book = new Product("หนังสือ Java", 500.0);
        Product pen = new Product("ปากกา", 20.0);

        // เรียกใช้งานเมธอดกับอ็อบเจกต์แต่ละตัว
        book.applyDiscount(10);  // ลดราคา 10%
        pen.applyDiscount(5);    // ลดราคา 5%

        book.printInfo();
        pen.printInfo();
    }
}
