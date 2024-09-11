public class BankingOperations {
    public void viewBalance() {
        UserLoginState loginState = UserLoginState.getInstance();
        if (loginState.isLoggedIn()) {
            System.out.println("Viewing balance for user " + loginState.getUsername());
            // Perform balance viewing operation
        } else {
            System.out.println("Please login first");
        }
    }

    public void deposit(double amount) {
        UserLoginState loginState = UserLoginState.getInstance();
        if (loginState.isLoggedIn()) {
            System.out.println("Depositing " + amount + " for user " + loginState.getUsername());
            // Perform deposit operation
        } else {
            System.out.println("Please login first");
        }
    }

    public void withdraw(double amount) {
        UserLoginState loginState = UserLoginState.getInstance();
        if (loginState.isLoggedIn()) {
            System.out.println("Withdrawing " + amount + " for user " + loginState.getUsername());
            // Perform withdrawal operation
        } else {
            System.out.println("Please login first");
        }
    }
}
