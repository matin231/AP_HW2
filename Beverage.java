public class Beverage extends MenuItem {
    private String size;
    private String temperature;

    public Beverage(int itemId, String name, int price, String size, String temperature) {
        super(itemId, name, price, "Beverage");
        this.size = size;
        this.temperature = temperature;
    }

    @Override
    public String getDetails() {
        return String.format("ID: %d, Name: %s, Price: %d, Category: %s, Size: %s, Temperature: %s",
                getItemId(), getName(), getPrice(), getCategory(), size, temperature);
    }
}