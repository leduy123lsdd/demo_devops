Feature: Get data from database
  Scenario: User type in customer number to login
    Given Customer number is 2
    When Get customer info from DB
    Then customer name is "Atelier graphique"
    And Phone number is "40.32.2555"
    And address is "54, rue Royale"
    And city is "Nantes"

  Scenario: Delete a customer
    Given customer number is 4
    When admin delete this account
    Then When find user in DB is not