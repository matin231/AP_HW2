public abstract class MenuItem {
    private int itemId;
    private String name;
    private int price;
    private String category;

    public MenuItem(int itemId, String name, int price, String category) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public abstract String getDetails();

    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }
}