Feature:Messaging Trash Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario:Managing deleted messages

    Given The user clicks on the Hamburger menu
    When  The user hovers over the messaging link
    And   The user clicks on the trash button
    Then  The user should display Delete and Restore options for each message
    When  The user clicks the Restore button for a message
    Then  The message should be successfully restored with a Success message
    When  The user clicks the Delete button for a message
    And   The user confirms the action in the confirmation pop-up window
    Then  The message should be permanently deleted with a Success message