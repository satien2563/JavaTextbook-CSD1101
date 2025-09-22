package chap07_Method;

class Book {
    String title;
}

public class Ex7_4_2b_PassByValueObjectNewRef {
    // เมธอดพยายามเปลี่ยนอ้างอิงไปยังอ็อบเจกต์ใหม่
    public static void resetBook(Book b) {
        b = new Book();          // สร้างอ็อบเจกต์ใหม่
        b.title = "Java Basics"; // กำหนดชื่อใหม่
        System.out.println("ภายในเมธอด: " + b.title);
    }

    public static void main(String[] args) {
        Book myBook = new Book();
        myBook.title = "OOP Concepts";

        resetBook(myBook); // ส่งอ็อบเจกต์เข้าเมธอด
        System.out.println("ภายนอกเมธอด: " + myBook.title);
    }
}
