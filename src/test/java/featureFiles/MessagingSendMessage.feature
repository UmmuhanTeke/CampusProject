Feature: Messaging Send Message Functionality

  Background:
    Given Navigate to campus
    When  Enter username and password and click login button
    Then  User should login successfully

  Scenario: Send Message Functionality
    Given The user clicks on the hamburger menu
    When  The user click send message
      | Hamburger menu |
      | Messaging      |
      | Send message   |

    Then  The user types and selects the receivers by clicking on the Add Receivers icon
      | usernameBox | Teacher |

    And  The user selects the message types and types the subject for it
    Then The user types the message text and uploads the file by clicking on the Attach Files button
    And  The user clicks on the save button and verifies the confirmation message
    When The user click outbox message and verifies the outbox message list
      | Hamburger menu |
      | Messaging      |
      | Outbox message |