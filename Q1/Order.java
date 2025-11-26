import java.util.*;

public class Order {
    private static int orderCounter = 1;
    private int orderId;
    private Customer customer;
    private List<MenuItem> items;
    private int totalAmount;

    public Order(Customer customer, List<MenuItem> items) {
        this.orderId = orderCounter++;
        this.customer = customer;
        this.items = items;
        calculateTotal();
    }

    private void calculateTotal() {
        int sum = 0;
        for (MenuItem item : items) {
            sum += item.getPrice();
        }
        customer.addLoyaltyPoints(sum);
        double discount = customer.getDiscount();
        totalAmount = (int)(sum * (1 - discount));
    }

    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Order ID: %d, Customer: %s, Total Amount: %d\nItems: ",
                orderId, customer.getName(), totalAmount));
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i).getName());
            if (i < items.size() - 1) sb.append(" - ");
        }
        return sb.toString();
    }

    public int getTotalAmount() { return totalAmount; }
}