Feature:Payment Functionality

  Background:
    Given The user navigates to the Campus website
    When  The user logs in to the system with a valid username and password
    Then  The user verifies that they have successfully logged into the Campus website
    And   The user clicks on the Hamburger menu
    Then  The user views the submenus in the Hamburger menu
    And   The user hovers over the Finance button in the Hamburger menu
    Then  The user views the My Finance submenu
    When  The user clicks the My Finance button
    Then  The user checks that they are redirected to the My Finance page

  Scenario:Payment Feature on My Finance Page

    Given The user has been redirected to the payment page
    Then  The user views the Online Payment and Fee/Balance Detail buttons
    And   The user clicks the Stripe button
      | stripeButton |

    Then  The user views the payment options
    When  The user clicks the Pay option and views the card information field
    And   The user enters card details and completes the payment
    Then  "The user views a message that the payment was successfully completed""
    Then  The user verifies that the payment has been completed
    When  The user clicks the New Message button in the top right corner of the toolbar
      | newMessageButton |

    Then  The user views the received message in the area