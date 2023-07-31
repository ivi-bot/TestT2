Feature: Order Calculation

Scenario: Applying quantity discount
  Given I have an order calculator
  When I apply a quantity discount for 24 items with a discount of 6
  Then the total discount should be 21.6

Scenario: Applying quantity discount with more than $50 purchase
  Given I have an order calculator
  When I apply a quantity discount for 120 items with a discount of 30
  Then the total discount should be 96

Scenario: Applying quantity discount with more than $100 purchase
  Given I have an order calculator
  When I apply a quantity discount for 400 items with a discount of 100
  Then the total discount should be 320

Scenario: Applying special menu category surcharge
  Given I have an order calculator
  When I apply a special category surcharge for the meal "Chef's Special Steak" with a price of 45 and availability
  Then the total surcharge should be 47.25

Scenario: Calculating total cost with more than 5 meals
  Given I have an order with the meal "croissant" and quantity of 4
  When I calculate the total cost for 6 meals
  Then the total cost should be 21.6

Scenario: Calculating total cost with more than 10 meals
  Given I have an order with the meal "croissant" and quantity of 4
  When I calculate the total cost for 15 meals
  Then the total cost should be 48

Scenario: Calculating the cost of a meal
  Given I have an order calculator
  When I calculate the cost of the meal "croissant" with a price of 4 and quantity of 20
  Then the meal cost should be 80

Scenario: Applying special offer discount
  Given I have an order calculator
  When I apply a special offer discount for a total price of 60
  Then the discounted price should be 50

Scenario: Applying special category surcharge
  Given I have an order calculator
  When I apply a special category surcharge for a total price of 300 with availability
  Then the total price should be 315
