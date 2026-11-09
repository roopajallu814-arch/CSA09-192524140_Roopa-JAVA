class Wallet {

    private int balance;

    Wallet(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void transfer(Wallet other, int amount) {

        Wallet first = this;
        Wallet second = other;

        if (System.identityHashCode(first) >
            System.identityHashCode(second)) {

            first = other;
            second = this;
        }

        synchronized (first) {
            synchronized (second) {

                if (balance >= amount) {
                    balance -= amount;
                    other.balance += amount;

                    System.out.println("Transfer successful");
                } else {
                    System.out.println("Insufficient balance");
                }
            }
        }
    }
}

public class WalletTransfer {

    public static void main(String[] args) {

        Wallet w1 = new Wallet(1000);
        Wallet w2 = new Wallet(500);

        Thread t1 = new Thread(() -> w1.transfer(w2, 200));
        Thread t2 = new Thread(() -> w2.transfer(w1, 100));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Wallet 1 balance: " + w1.getBalance());
        System.out.println("Wallet 2 balance: " + w2.getBalance());
    }
}