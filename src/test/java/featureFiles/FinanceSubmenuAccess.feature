Feature:Hamburger Menu Functionality

  Scenario:Finance Submenu Access

    Given The user navigates to the Campus website
    When  The user logs in to the system with a valid username and password
    Then  The user verifies that they have successfully logged into the Campus website
    And   The user clicks on the Hamburger menu
    Then  The user views the submenus in the Hamburger menu
    And   The user hovers over the Finance button in the Hamburger menu
    Then  The user views the My Finance submenu
    When  The user clicks the My Finance button
    Then  The user checks that they are redirected to the My Finance page