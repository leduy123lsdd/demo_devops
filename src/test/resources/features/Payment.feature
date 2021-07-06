Feature: Payment control for end user
  Scenario: User find history of their purchase
    Given customer number is 1
    Then payment return with check number is 2 with the nearest purchase.

  Scenario: User find history of a dont exist purchase
    Given customer number is 1
    Then payment return with check number is 23423 with the nearest purchase.

  Scenario: User make new purchase
    Given customer purchase info
      |customerNumber|paymentDate|amount|
      |6|22/07/2011|22|
    Then upload status code is 200

