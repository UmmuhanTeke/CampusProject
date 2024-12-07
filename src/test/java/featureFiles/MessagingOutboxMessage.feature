Feature: Messaging Outbox Message Functionality

  Background:
    Given Navigate to campus
    When  Enter username and password and click login button
    Then  User should login successfully

  Scenario: Outbox Message Functionality
    Given The user clicks on the hamburger menu
    When  The user hovers over the messaging link
    Then  The user clicks outbox message and verifies the outbox message list
      | outboxMessage |

    When The user clicks the Yes button in the confirm window by clicking on the Move to Trash icon
    Then The user verifies the confirmation message