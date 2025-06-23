Feature: Login Functionality

  Scenario: Valid user logs into the portal
    Given the login page is open
    Then Username field should present
    And Username field should be writable
    And Password field should be present
    And Password field should be writable
    And Login button should present
    And Login button label should be "Login"
    And the login button should be enabled
    And the new user button should be visible
    When username "sandy" is entered
    And password "SandyPass@123" is entered
    And the login button is clicked


