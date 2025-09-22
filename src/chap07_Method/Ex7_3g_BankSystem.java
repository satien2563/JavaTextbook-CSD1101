package chap07_Method;

public class Ex7_3g_BankSystem {
    private static double balance = 0.0;  // เก็บยอดเงินคงเหลือ

    // เมธอดฝากเงิน
    public static void deposit(double amount) {
        balance += amount;
        System.out.println("ฝากเงินจำนวน " + amount + " บาท เรียบร้อยแล้ว");
    }

    // เมธอดถอนเงิน
    public static void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("ถอนเงินจำนวน " + amount + " บาท เรียบร้อยแล้ว");
        } else {
            System.out.println("ยอดเงินไม่เพียงพอในการถอน");
        }
    }

    // เมธอดตรวจสอบยอดเงิน
    public static double checkBalance() {
        return balance;
    }

    public static void main(String[] args) {
        deposit(5000.0);  // ฝากเงิน
        withdraw(2000.0); // ถอนเงิน
        System.out.println("ยอดเงินคงเหลือ: " + checkBalance() + " บาท");
    }
}