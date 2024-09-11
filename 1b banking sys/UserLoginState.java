// Singleton class to maintain the User Login-State
public class UserLoginState {
    private static UserLoginState instance;
    private boolean isLoggedIn;
    private String username;

    // Private constructor to prevent instantiation from outside
    private UserLoginState() {}

    // Public method to get the instance of UserLoginState
    public static UserLoginState getInstance() {
        if (instance == null) {
            instance = new UserLoginState();
        }
        return instance;
    }

    // Method to login the user
    public void login(String username, String password) {
        // Assume password verification is done here
        isLoggedIn = true;
        this.username = username;
    }

    // Method to logout the user
    public void logout() {
        isLoggedIn = false;
        username = null;
    }

    // Method to check if the user is logged in
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    // Method to get the logged in username
    public String getUsername() {
        return username;
    }
}