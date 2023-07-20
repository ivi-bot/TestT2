public class Meal {
    private final String name;
    private final double price;
    private final boolean isSpecialCategory;

    public Meal(String name, double price, boolean isSpecialCategory) {
        this.name = name;
        this.price = price;
        this.isSpecialCategory = isSpecialCategory;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSpecialCategory() {
        return isSpecialCategory;
    }
}
