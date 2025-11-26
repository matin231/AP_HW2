public class Customer extends Person {
    private static int customerCounter = 1;
    private String customerId;
    private int loyaltyPoints;

    public Customer(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.customerId = String.format("C%03d", customerCounter++);
        this.loyaltyPoints = 0;
    }

    public void addLoyaltyPoints(int amount) {
        if (amount > 1_000_000) loyaltyPoints += 2;
        else if (amount > 500_000) loyaltyPoints += 1;
    }

    public double getDiscount() {
        if (loyaltyPoints > 5) return 0.10;
        else if (loyaltyPoints > 3) return 0.05;
        return 0.0;
    }

    public String getCustomerId() { return customerId; }
    public int getLoyaltyPoints() { return loyaltyPoints; }

    @Override
    public String getInfo() {
        return String.format("ID: %s, Name: %s, Phone: %s, Loyalty Points: %d",
                customerId, getName(), getPhoneNumber(), loyaltyPoints);
    }
}