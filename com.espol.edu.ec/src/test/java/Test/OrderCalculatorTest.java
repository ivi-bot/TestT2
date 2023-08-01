package Test;

import org.junit.Assert;

import com.espol.edu.ec.Meal;
import com.espol.edu.ec.Order;
import com.espol.edu.ec.OrderCalculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderCalculatorTest {
	private OrderCalculator order;
    private double actualValue;
    private Meal mealorder;
    private Order singleorder;
@Given("I have an order calculator")
public void i_have_an_order_calculator() {
   System.out.println("I have an order calculator");
   order = new OrderCalculator();

}

@When("I apply a quantity discount for {int} items with a discount of {int}")
public void i_apply_a_quantity_discount_for_items_with_a_discount_of(Integer item, Integer discount) {
	   System.out.println("I apply a quantity discount for "+ item +" items with a discount of"+discount.toString());
       actualValue = order.applyQuantityDiscount(item, discount);        

}

@Then("the total discount should be {double}")
public void the_total_discount_should_be(Double totalDiscount) {
	   System.out.println("the total discount should be "+totalDiscount.toString());
       Assert.assertEquals(totalDiscount, actualValue, 0.001); //

}




@Given("I have an order calculator surchage special")
public void i_have_an_order_calculator_surcharge() {
   System.out.println("I have an order calculator surchage special");
   order = new OrderCalculator();

}

@When("I apply a special category surcharge for the meal {string} with a price of {int} and availability")
public void i_apply_a_special_category_surcharge_for_the_meal_with_a_price_of_and_availability(String meal, Integer price) {
	   System.out.println("I apply a special category surcharge for the meal "+meal+" with a price of"+ price.toString() +"and availability");
	   mealorder = new Meal(meal,3, false);
	   actualValue=order.applySpecialCategorySurcharge(price,true);


}

@Then("the total surcharge should be {double}")
public void the_total_surcharge_should_be(Double total) {
   System.out.println("the total surcharge should be "+total.toString());
   Assert.assertEquals(total, actualValue, 0.001); //

}



@Given("I have an order with the meal {string} and quantity of {int}")
public void i_have_an_order_with_the_meal_and_quantity_of(String meal, Integer quantity) {
    System.out.println("I have an order with the meal "+meal+ " and quantity of "+quantity.toString());
    order = new OrderCalculator();
    singleorder = new Order();
	mealorder = new Meal(meal,quantity, false);

}

@When("I calculate the total cost for {int} meals")
public void i_calculate_the_total_cost_for_meals(Integer mealsquantity) {
	System.out.println("I calculate the total cost for " + mealsquantity.toString() + " meals");
	singleorder.addMeal(mealorder, mealsquantity);
	actualValue = order.calculateTotalCost(singleorder); 
}

@Then("the total cost should be {double}")
public void the_total_cost_should_be(Double totalcost) {
	System.out.println("The total cost should be "+totalcost.toString());
	Assert.assertEquals(totalcost, actualValue, 0.001); //

}



@Given("I have an order calculator special")
public void i_have_an_order_calculator_special() {
   System.out.println("I have an order calculator special");
   order = new OrderCalculator();

}

@When("I apply a special offer discount for a total price of {int}")
public void i_apply_a_special_offer_discount_for_a_total_price_of(Integer totalprice) {
	System.out.println("I apply a special offer discount for a total price of " + totalprice.toString());
	actualValue=order.applySpecialOfferDiscount(totalprice);
}

@Then("the discounted price should be {int}")
public void the_discounted_price_should_be(Integer discount) {
	System.out.println("the discounted price should be "+ discount.toString());
	Assert.assertEquals(discount, actualValue, 0.001); //

}




@Given("I have an order calculator category")
public void i_have_an_order_calculator_category() {
   System.out.println("I have an order calculator category");
   order = new OrderCalculator();

}

@When("I apply a special category surcharge for a total price of {int} with availability")
public void i_apply_a_special_category_surcharge_for_a_total_price_of_with_availability(Integer totalprice) {
	System.out.println("I apply a special category surcharge for a total price of "+ totalprice.toString()+ " with availability");
	actualValue=order.applySpecialCategorySurcharge(totalprice,true);
}

@Then("the total price should be {int}")
public void the_total_price_should_be(Integer totalprice) {
	System.out.println("the total price should be "+totalprice.toString());
	Assert.assertEquals(totalprice, actualValue, 0.001); //

}


}
