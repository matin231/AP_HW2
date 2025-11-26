public class Food extends MenuItem {
    private String spiceLevel;
    private int preparationTime;

    public Food(int itemId, String name, int price, String spiceLevel, int preparationTime) {
        super(itemId, name, price, "Food");
        this.spiceLevel = spiceLevel;
        this.preparationTime = preparationTime;
    }

    @Override
    public String getDetails() {
        return String.format("ID: %d, Name: %s, Price: %d, Category: %s, Spice: %s, Preparation Time: %dmin",
                getItemId(), getName(), getPrice(), getCategory(), spiceLevel, preparationTime);
    }
}