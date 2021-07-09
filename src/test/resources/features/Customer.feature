Feature: User feature
  Scenario: User type in customer number to login
    Given Customer number is 1
    When Send request login
    Then Notion back is "Login success"