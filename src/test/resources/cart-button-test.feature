Feature: Test automationpractice.com

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








#  Scenario: I get get rooms
#    Given I ask you to give me back the room numbers
#  Scenario: I get get users
#    Given I ask you to give me back the users. start = 1 end = 5
#
#
#  Scenario Outline: I check the privileges of all users
#    When I check to enter the room. userId = <id> maxRoom = <room>
#    Examples: I enter the rooms
#      | id | room |
#      | 1  | 5    |
#      | 2  | 5    |
#      | 3  | 5    |
#      | 5  | 5    |
#      | 6  | 5    |
#      | 7  | 5    |
#      | 8  | 5    |
#      | 9  | 5    |
#      | 10 | 5    |