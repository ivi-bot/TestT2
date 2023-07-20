import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Meal, Integer> selectedMeals;

    public Order() {
        this.selectedMeals = new HashMap<>();
    }

    public void addMeal(Meal meal, int quantity) {
        selectedMeals.put(meal, quantity);
    }

    public Map<Meal, Integer> getSelectedMeals() {
        return selectedMeals;
    }
}
