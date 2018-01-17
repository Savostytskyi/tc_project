Feature: Header menu navigation

  @smokeTest
  Scenario: Navigate to 'Gift Cards' page
    Given I am on Home page
    When I select 'Gift Cards' menu item
    Then Gift Cards page opened

  @smokeTest @failed
  Scenario: Navigate to 'Gift Cards' page
    Given I am on Home page
    When I select 'Registry' menu item
    Then Gift Cards page opened
