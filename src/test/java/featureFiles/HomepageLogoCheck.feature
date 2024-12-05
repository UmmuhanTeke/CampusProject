Feature:Homepage Logo Functionality

  Scenario:Homepage Logo Check

    Given The user navigates to the Campus website
    When  The user logs in to the system with a valid username and password
    Then  The user verifies that they have successfully logged into the Campus website
    And   The user Techno Study website logo is displayed in the top left corner
    When  The user clicks on the Techno Study website logo
    Then  The user checks the redirected page using the URL