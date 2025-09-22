package chap07_Method;

class BankAccount {
    private double balance; // ตัวแปรเก็บยอดเงิน (Encapsulation)

    // เมธอดฝากเงิน
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // เมธอดตรวจสอบยอดเงิน
    public double getBalance() {
        return balance;
    }
}

public class Ex7_5_1a_ClassMethodDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(); // สร้างอ็อบเจกต์บัญชี
        account.deposit(1000.0); // เรียกใช้เมธอด deposit
        System.out.println("ยอดเงินคงเหลือ: " + account.getBalance() + " บาท");
    }
}

