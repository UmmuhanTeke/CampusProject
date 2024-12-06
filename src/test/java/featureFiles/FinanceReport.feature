Feature: Finance Report Management

  Scenario: Accessing and downloading finance reports
    Given The user clicks on the hamburger menu
    When  The user navigates to Finance and then to My Finance
    Then  The user should access the finance page
    When  The user clicks on the three-dot dropdown menu for report types
    And   The user selects a report format
    Then  The user should be successfully downloaded to the local drive
