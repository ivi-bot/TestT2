import java.util.Map;

public class OrderCalculator {
    private static final double BASE_MEAL_COST = 5.0;
    private static final double DISCOUNT_THRESHOLD_1 = 5;
    private static final double DISCOUNT_THRESHOLD_2 = 10;
    private static final double DISCOUNT_1 = 0.10;
    private static final double DISCOUNT_2 = 0.20;
    private static final double SPECIAL_CATEGORY_SURCHARGE = 0.05;
    private static final double SPECIAL_OFFER_DISCOUNT_THRESHOLD_1 = 50.0;
    private static final double SPECIAL_OFFER_DISCOUNT_THRESHOLD_2 = 100.0;
    private static final double SPECIAL_OFFER_DISCOUNT_1 = 10.0;
    private static final double SPECIAL_OFFER_DISCOUNT_2 = 25.0;

        public static double calculateTotalCost(Order order) {
            Map<Meal, Integer> selectedMeals = order.getSelectedMeals();
            int totalQuantity = 0;
            double totalCost = 0;
            boolean specialCategoryIncluded = false;

            for (Meal meal : selectedMeals.keySet()) {
            	
            	int quantity = selectedMeals.get(meal);
            	totalQuantity += quantity;

            	
                double mealCost = calculateMealCost(meal, selectedMeals.get(meal));
                totalCost += mealCost;

                if (meal.isSpecialCategory()) {
                    specialCategoryIncluded = true;
                }
            }

            totalCost = applyQuantityDiscount(totalCost, totalQuantity);
            totalCost = applySpecialOfferDiscount(totalCost);
            totalCost = applySpecialCategorySurcharge(totalCost, specialCategoryIncluded);

            return totalCost;
        }

        public static double calculateMealCost(Meal meal, int quantity) {
            return meal.getPrice() * quantity;
        }

        public static double applyQuantityDiscount(double totalCost, int totalMeals) {
            if (totalMeals > DISCOUNT_THRESHOLD_2) {
                totalCost *= (1 - DISCOUNT_2);
            } else if (totalMeals > DISCOUNT_THRESHOLD_1) {
                totalCost *= (1 - DISCOUNT_1);
            }
            return totalCost;
        }

        public static double applySpecialOfferDiscount(double totalCost) {
            if (totalCost > SPECIAL_OFFER_DISCOUNT_THRESHOLD_2) {
                totalCost -= SPECIAL_OFFER_DISCOUNT_2;
            } else if (totalCost > SPECIAL_OFFER_DISCOUNT_THRESHOLD_1) {
                totalCost -= SPECIAL_OFFER_DISCOUNT_1;
            }
            return totalCost;
        }

        public static double applySpecialCategorySurcharge(double totalCost, boolean specialCategoryIncluded) {
            if (specialCategoryIncluded) {
                totalCost *= (1 + SPECIAL_CATEGORY_SURCHARGE);
            }
            return totalCost;
        }
    }