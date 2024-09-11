import java.util.HashMap;
import java.util.Map;

// Singleton for user authentication management
class UserAuth {
    private static UserAuth instance;

    private Map<String, String> users = new HashMap<>();

    private UserAuth() {
        // Private constructor for Singleton
    }

    public static synchronized UserAuth getInstance() {
        if (instance == null) {
            instance = new UserAuth();
        }
        return instance;
    }

    public boolean authenticate(String username, String password) {
        // Simple authentication logic
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public void registerUser(String username, String password) {
        users.put(username, password);
    }
}

// Abstract Factory for payment methods
interface PaymentFactory {
    PaymentMethod createPaymentMethod();
}

interface PaymentMethod {
    void processPayment();
}

class CreditCardPaymentFactory implements PaymentFactory {
    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }
}

class PayPalPaymentFactory implements PaymentFactory {
    @Override
    public PaymentMethod createPaymentMethod() {
        return new PayPalPayment();
    }
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment...");
    }
}

// Factory Method for vehicle creation
interface Vehicle {
    void ride();
}

abstract class VehicleFactory {
    public abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}

class ScooterFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Scooter();
    }
}

class Car implements Vehicle {
    @Override
    public void ride() {
        System.out.println("Riding a car...");
    }
}

class Bike implements Vehicle {
    @Override
    public void ride() {
        System.out.println("Riding a bike...");
    }
}

class Scooter implements Vehicle {
    @Override
    public void ride() {
        System.out.println("Riding a scooter...");
    }
}
