package com.espol.edu.ec;
import java.util.Scanner;

public class Main {

	private static final int MAX_MEAL_QUANTITY = 100;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Menu menu = new Menu();
		String confirmation = "no";

		System.out.println("Welcome to the Dining Experience Manager!");

		while (confirmation.equals("no")) {
			Order order = new Order();
			menu.displayMenu();

			while (true) {
				System.out.print("\nEnter the name of the meal you want to order (or 'done' to finish): ");
				String mealName = scanner.nextLine().toLowerCase();

				if (mealName.equals("done")) {
					break;
				}

				if (!menu.isValidMeal(mealName)) {
					System.out.println("Invalid meal selection. Please choose from the available meals.");
					continue;
				}

				Meal meal = menu.getMeal(mealName);
				int quantity = readMealQuantity(scanner);
				order.addMeal(meal, quantity);
			}

			System.out.println("\nYour order summary:");
			displayOrderSummary(order);
			double totalCost = OrderCalculator.calculateTotalCost(order);
			System.out.println("Total cost: $" + totalCost);
			System.out.print("\nConfirm your order (yes/no/cancel): ");
			confirmation = scanner.nextLine().toLowerCase();

			if (confirmation.equals("yes")) {
				totalCost = OrderCalculator.calculateTotalCost(order);
				if (totalCost == -1) {
					System.out.println("Order canceled due to invalid input.");
				} else {
					System.out.println("Total cost: $" + totalCost);
				}
			} else {
				System.out.println("Order canceled.");
			}
		}
	}

	private static void displayOrderSummary(Order order) {
		System.out.println("Selected meals:");
		for (Meal meal : order.getSelectedMeals().keySet()) {
			int quantity = order.getSelectedMeals().get(meal);
			System.out.println(meal.getName() + " x " + quantity);
		}
	}

	private static int readMealQuantity(Scanner scanner) {
		int quantity;
		while (true) {
			System.out.print("Enter the quantity for this meal: ");
			try {
				quantity = Integer.parseInt(scanner.nextLine());
				if (quantity > 0 && quantity <= MAX_MEAL_QUANTITY) {
					break;
				} else {
					System.out.println("Invalid quantity. Please enter a positive integer (1 to 100).");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid integer.");
			}
		}
		return quantity;

	}

}
