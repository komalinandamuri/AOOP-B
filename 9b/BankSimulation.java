public class BankSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);  // Initial balance of 1000

        // Create multiple threads to simulate users performing transactions
        Thread user1 = new Thread(new User(account), "User1");
        Thread user2 = new Thread(new User(account), "User2");
        Thread user3 = new Thread(new User(account), "User3");

        // Start the threads
        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}

class User implements Runnable {
    private BankAccount account;

    public User(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(Math.random() * 100);
            account.withdraw(Math.random() * 50);

            try {
                Thread.sleep(100);  // Pause for a bit to simulate real-world usage
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
