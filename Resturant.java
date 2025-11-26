import java.util.*;

public class Resturant {
    public static void main(String[] args) {
        Employee e1 = new Employee("matin", "09913441755", "chef", 8000000);
        Employee e2 = new Employee("Ali", "09120000000", "accountant", 7000000);
        Employee e3 = new Employee("mamad", "09350000000", "waiter", 6000000);

        e1.addHoursWorked(170);
        e2.addHoursWorked(150);
        e3.addHoursWorked(200);

        Customer c1 = new Customer("Shayan", "09351234567");
        Customer c2 = new Customer("Hamed", "09125558066");
        Customer c3 = new Customer("Hooman", "09121212122");
        Customer c4 = new Customer("Niloofar", "09121112222");
        Customer c5 = new Customer("Reza", "09351111111");

        List<MenuItem> menu = new ArrayList<>();
        menu.add(new Food(1, "Pizza", 400000, "Medium", 25));
        menu.add(new Food(2, "Burger", 350000, "Mild", 20));
        menu.add(new Beverage(3, "Tea", 60000, "Large", "Hot"));
        menu.add(new Beverage(4, "Soda", 80000, "Medium", "Cold"));
        menu.add(new Food(5, "Pasta", 300000, "Spicy", 30));

        List<Order> orders = new ArrayList<>();
        Customer[] customers = {c1, c2, c3, c4, c5};
        for (Customer customer : customers) {
            orders.add(new Order(customer, Arrays.asList(menu.get(0), menu.get(1))));
            orders.add(new Order(customer, Arrays.asList(menu.get(2), menu.get(3))));
            orders.add(new Order(customer, Arrays.asList(menu.get(1), menu.get(4))));
        }
        System.out.println("\n Employee Salaries:");
        for (Employee e : Arrays.asList(e1, e2, e3)) {
            System.out.printf("%s: %.0f Toman\n", e.getName(), e.calculateSalary());
        }
        Customer mostLoyal = c1;
        for (Customer c : customers) {
            if (c.getLoyaltyPoints() > mostLoyal.getLoyaltyPoints()) {
                mostLoyal = c;
            }
        }
        System.out.println("\n Most Loyal Customer:");
        System.out.println(mostLoyal.getInfo());
        System.out.println("\n Customer Information:");
        for (Customer c : customers) {
            System.out.println(c.getInfo());
        }
        System.out.println("\n Employee Information:");
        for (Employee e : Arrays.asList(e1, e2, e3)) {
            System.out.println(e.getInfo());
        }

        System.out.println("\n Restaurant Menu:");
        for (MenuItem item : menu) {
            System.out.println(item.getDetails());
        }
        System.out.println("\n Order Summaries:");
        for (Order o : orders) {
            System.out.println(o.getOrderSummary());
        }
    }
}