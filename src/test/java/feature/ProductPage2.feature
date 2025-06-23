Feature: Product Page 2 Functionality

  Scenario: View product details and add to cart
    Given the product details page is opened
    Then there should be visible product name
    And the product image should be displayed
    When selecting the color "Black"
    And selecting the size "7"
    Then the product price should be "$155"


