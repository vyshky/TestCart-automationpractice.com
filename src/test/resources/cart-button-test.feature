Feature: Test button cart - automationpractice.com

  Background: I am checking if the website can be opened
    Given  I open page

  Scenario: I am checking if it is possible to add and remove a product to the cart
    When I add a product
    And I am checking if there is a product - Not Empty
    Then I am removing a product

  Scenario: I check the number of products page in the basket and in the pop-up block cart
    When I open cart page
    Then I check the number of items on the cart page and cart block

  Scenario: I check the quantity of the first product
    Given I check the first product count

    Scenario: I test color cart button
      Given I am testing color shopping cart icon