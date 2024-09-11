public class Payment {
    public static void main(String[] args) {
        // User Authentication Test
        UserAuth auth = UserAuth.getInstance();
        auth.registerUser("john_doe", "password123");

        boolean isAuthenticated = auth.authenticate("john_doe", "password123");
        System.out.println("User authenticated: " + isAuthenticated);

        // Vehicle Creation Test
        VehicleFactory carFactory = new CarFactory();
        Vehicle car = carFactory.createVehicle();
        car.ride();

        VehicleFactory bikeFactory = new BikeFactory();
        Vehicle bike = bikeFactory.createVehicle();
        bike.ride();

        VehicleFactory scooterFactory = new ScooterFactory();
        Vehicle scooter = scooterFactory.createVehicle();
        scooter.ride();

        // Payment Method Test
        PaymentFactory creditCardFactory = new CreditCardPaymentFactory();
        PaymentMethod creditCardPayment = creditCardFactory.createPaymentMethod();
        creditCardPayment.processPayment();

        PaymentFactory paypalFactory = new PayPalPaymentFactory();
        PaymentMethod paypalPayment = paypalFactory.createPaymentMethod();
        paypalPayment.processPayment();
    }
}
