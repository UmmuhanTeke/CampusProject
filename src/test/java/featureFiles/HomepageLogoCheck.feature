Feature:Homepage Logo Functionality

  Background:
    Given Navigate to Campus
    When  The user types username and password and click login button
    Then  The user verifies login successfully

  Scenario:Homepage Logo Check

    Given The user is on the Campus homepage
    And   The user Techno Study website logo is displayed in the top left corner
    When  The user clicks on the Techno Study website logo
    Then  The user checks the redirected page using the URL