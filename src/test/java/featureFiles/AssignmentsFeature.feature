Feature:Assignments Feature Functionality

  Background:
    Given Navigate to Campus
    When  The user types username and password and click login button
    Then  The user verifies login successfully
    And   The user clicks on the Assignment button

  Scenario:Assignments Search Functionality
    Given The user is on the Assignments page
    When  The user clicks the search button on the default Assignments page
    Then  The user views the list of all assigned tasks
    And   The user filters the search (Course,Status,Semester)
    And   The user accesses a dropdown menu to sort search results on the Assignments page
    And   The user can sort results by course, type, date, and table from the dropdown menu