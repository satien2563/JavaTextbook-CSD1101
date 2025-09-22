package chap07_Method;

class SavingAccount {
    private double balance; // ตัวแปรอินสแตนซ์เก็บยอดเงิน

    // เมธอดฝากเงิน
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // เมธอดถอนเงิน
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // เมธอดตรวจสอบยอดเงิน
    public double getBalance() {
        return balance;
    }
}

public class Ex7_5_2a_InstanceMethodDemo {
    public static void main(String[] args) {
        SavingAccount account1 = new SavingAccount();
        SavingAccount account2 = new SavingAccount();

        // ทำงานกับอ็อบเจกต์ account1
        account1.deposit(2000.0);
        account1.withdraw(500.0);
        System.out.println("ยอดเงินของ account1: " + account1.getBalance() + " บาท");

        // ทำงานกับอ็อบเจกต์ account2
        account2.deposit(1000.0);
        System.out.println("ยอดเงินของ account2: " + account2.getBalance() + " บาท");
    }
}
