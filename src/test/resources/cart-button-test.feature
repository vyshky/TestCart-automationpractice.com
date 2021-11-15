Feature: Test button cart - automationpractice.com

  Background: I am checking if the website can be opened
    Given  I open page

  Scenario: I am checking if it is possible to add a product to the cart
    Given I add a product

  Scenario: I am checking if it is possible to remove products from the cart
    Given I am removing a product

  Scenario: I check if there are any products in the basket
    Given I am checking if there is a product

  Scenario: I check if the cart button works
    Given I open cart page

  Scenario: I check the number of products in the basket and in the pop-up block
    Given I check the number of products in the basket


  Scenario: I check the quantity of the first product
    Given I check the quantity