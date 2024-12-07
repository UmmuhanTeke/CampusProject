Feature:Hamburger Menu Functionality

  Background:
    Given Navigate to Campus
    When  The user types username and password and click login button
    Then  The user verifies login successfully

  Scenario:Finance Submenu Access

    Given The user is on the Campus homepage
    And   The user clicks on the Hamburger menu
    Then  The user views the submenus in the Hamburger menu
    And   The user hovers over the Finance button in the Hamburger menu
    Then  The user views the My Finance submenu
    When  The user clicks the My Finance button
    Then  The user checks that they are redirected to the My Finance page