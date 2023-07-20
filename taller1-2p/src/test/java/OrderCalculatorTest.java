/**
 * 
 */

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class OrderCalculatorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDiscount() {

		OrderCalculator order = new OrderCalculator();
        double expectedValue = 21.6;
        double actualValue = order.applyQuantityDiscount(24, 6);        
        assertEquals(expectedValue, actualValue, 0.001); //

	}
	
	//More $50
	@Test
	public void testDiscount2() {

		OrderCalculator order = new OrderCalculator();
        double expectedValue = 96;
        double actualValue = order.applyQuantityDiscount(120, 30);        
        assertEquals(expectedValue, actualValue, 0.001); //

	}
	
	//More $100
		@Test
		public void testDiscount3() {

			OrderCalculator order = new OrderCalculator();
	        double expectedValue = 320;
	        double actualValue = order.applyQuantityDiscount(400, 100);        
	        assertEquals(expectedValue, actualValue, 0.001); //

		}
		
		//Special menu
		@Test
		public void testDiscount4() {
			OrderCalculator ordercalculator = new OrderCalculator();

			Meal meal = new Meal("Chef's Special Steak",3, false);
			double actualValue=ordercalculator.applySpecialCategorySurcharge(45,true);
	        double expectedValue = 47.25;

	        assertEquals(expectedValue, actualValue, 0.001); //
		}
		
		
		
	@Test
	public void testcalculateTotalCostmore5() {

		Order order = new Order();
		Meal meal = new Meal("croissant",4, false);
		order.addMeal(meal, 6);
		OrderCalculator ordercalculator = new OrderCalculator();

        double actualValue = ordercalculator.calculateTotalCost(order);   
        
        double expectedValue = 21.6;
        
        assertEquals(expectedValue, actualValue, 0.001); //

	}
	
	@Test
	public void testcalculateTotalCostmore10() {

		Order order = new Order();
		Meal meal = new Meal("croissant",4, false);
		order.addMeal(meal, 15);
		OrderCalculator ordercalculator = new OrderCalculator();

        double actualValue = ordercalculator.calculateTotalCost(order);   
        
        double expectedValue = 48;
        
        assertEquals(expectedValue, actualValue, 0.001); //

	}
	
	@Test
	public void testcalculateMealCost() {
		OrderCalculator ordercalculator = new OrderCalculator();

		Meal meal = new Meal("croissant",4, false);
		double actualValue=ordercalculator.calculateMealCost(meal,20);
        
        double expectedValue = 80;
        
        assertEquals(expectedValue, actualValue, 0.001); //
	}
	
	@Test
	public void testapplySpecialOfferDiscount() {
		OrderCalculator ordercalculator = new OrderCalculator();

		double actualValue=ordercalculator.applySpecialOfferDiscount(60);
        double expectedValue = 50;

        assertEquals(expectedValue, actualValue, 0.001); //
	}
	
	@Test
	public void testapplySpecialCategorySurcharge() {
		OrderCalculator ordercalculator = new OrderCalculator();

		Meal meal = new Meal("croissant",4, false);
		double actualValue=ordercalculator.applySpecialCategorySurcharge(300,true);
        double expectedValue = 315;

        assertEquals(expectedValue, actualValue, 0.001); //
	}
	
	
	
	
	
	
}
