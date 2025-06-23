Feature: User Registration Functionality

  Scenario: Register a new user with valid data
    Given the registration page is open
    Then the registration page heading should be "User Registration Page"
    When first name "Sandy" is entered
    And last name "Smith" is entered
    And email "sandy@example.com" is entered
    And contact number "01712345678" is entered
    And New Username is entered "sandy"
    And new user password is entered "SandyPass@123"
    Then the submit button should be enabled
    When the submit button is clicked
