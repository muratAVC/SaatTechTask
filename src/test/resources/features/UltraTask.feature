@ultra
Feature: Ultra task feature

  Background: user open the page
    Given User open page

  Scenario Outline: Users can be login
    Given user add to "<username>"
    And user add password "<password>"
    And user click to login button
    And user can see main page
    Examples: username and password
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

@sort
  Scenario Outline: User can be login then user sort to products
    Given user add to "<username>"
    And user add password "<password>"
    And user click to login button
    And user can see sort button
    And user click to sort button "<sortList>"
    And user can see sort result "<sortList>"

    Examples: user
    |username|password|sortList|
    |standard_user|secret_sauce|Name (A to Z)|
    |standard_user|secret_sauce|Name (Z to A)|
    |standard_user|secret_sauce|Price (low to high)|
    |standard_user|secret_sauce|Price (high to low)|

  @product
Scenario Outline: User can be login and product add to cart
    Given user add to "<username>"
    And user add password "<password>"
    And user click to login button
    And user click to left menu button
    And user click to reset button
    And user can see add to cart button
    And user product adding to cart
    And user can see inside the cart
    And user click to reset button
    And user can see inside the cart
    And remove button change to add to cart button

  Examples: username and password
    | username      | password     |
    | standard_user | secret_sauce |
