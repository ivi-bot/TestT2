import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, Meal> meals;

    public Menu() {
        this.meals = new HashMap<>();
        initializeMenu();
    }

    private void initializeMenu() {
        // Add meals and their corresponding prices to the menu
        meals.put("chicken teriyaki", new Meal("Chicken Teriyaki", 8.0, false));
        meals.put("spaghetti carbonara", new Meal("Spaghetti Carbonara", 10.0, false));
        meals.put("croissant", new Meal("Croissant", 4.0, false));
        meals.put("chef's special steak", new Meal("Chef's Special Steak", 15.0, true));
        // Add more meals as needed
    }

    public boolean isValidMeal(String mealName) {
        return meals.containsKey(mealName.toLowerCase());
    }

    public Meal getMeal(String mealName) {
        return meals.get(mealName.toLowerCase());
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (Meal meal : meals.values()) {
            System.out.println(meal.getName() + " - $" + meal.getPrice());
        }
    }
}
