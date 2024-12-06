Feature:Messaging Trash Functionality

  Background:
    Given Navigate to campus
    When  Enter username and password and click login button
    Then  User should login successfully

  Scenario:Managing deleted messages

    Given The user clicks on the hamburger menu
    When  The user hovers over the messaging link
    And   The user clicks on the trash button
    Then  The user should display Delete and Restore options for each message
    When  The user clicks the Restore button for a message
    Then  The message should be successfully restored with a Success message
    When  The user clicks the Delete button for a message
    And   confirms the action in the confirmation popup
    Then  The message should be permanently deleted with a Success message