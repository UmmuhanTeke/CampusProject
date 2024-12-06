Feature: Finance Report Management

  Background:
    Given Navigate to campus
    When  Enter username and password and click login button
    Then  User should login successfully

  Scenario: Accessing and downloading finance reports

    Given The user clicks on the hamburger menu
    When  The user navigates to Finance and then to My Finance
    Then  The user should access the finance page
    When  The user clicks on the three-dot dropdown menu for report types
    And   The user selects a report format
    Then  The user should be successfully downloaded to the local drive
