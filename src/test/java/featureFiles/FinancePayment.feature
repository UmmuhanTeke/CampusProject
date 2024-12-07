Feature:Financial Payment Functionality
  Background:
    Given Navigate to campus
    When  Enter username and password and click login button
    Then  User should login successfully

  Scenario:Successful Payment

    When The user hovers over the Hamburger Menu and clicks on My Finance
         | hamburgerMenu   |
         | myFinanceButton |
    And  The user clicks their name and is redirected to the payment page
         | stripeButton |
    When The user enters the amount and clicks the pay button
         |amount|
         | 235  |
    And  The payment should be processed successfully
    When The user enters their card details
         |cardNumber         |
         |4242 4242 4242 4242|
    And  The user confirms the payment
    Then The user displays a confirmation message "Payment Successful"
