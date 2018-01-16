Feature: User manipulation

  Scenario: Get user by id
    Given User posts service is up and running
    When I add user post with parameters:
      | userId | id   | title | body |
      | 1000   | 1000 | Test  | Test |
    Then Response status is 201
    And I receive user post information:
      | userId | id   | title | body |
      | 1000   | 1000 | Test  | Test |

  Scenario: Add user
    Given User posts service is up and running
    When I request user post by id '1'
    Then Response status is 200
    And I receive user post information:
      | userId | id | title | body |
      | 1      | 1  | test  | test |
