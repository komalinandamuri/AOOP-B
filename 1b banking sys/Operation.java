public class Operation {
    public static void main(String[] args) {
        BankingOperations bankingOperations = new BankingOperations();

        // Login the user
        UserLoginState loginState = UserLoginState.getInstance();
        loginState.login("johnDoe", "password123");

        // Perform banking operations
        bankingOperations.viewBalance();
        bankingOperations.deposit(100.0);
        bankingOperations.withdraw(50.0);

        // Logout the user
        loginState.logout();

        // Try to perform banking operations without login
        bankingOperations.viewBalance();
    }
}
