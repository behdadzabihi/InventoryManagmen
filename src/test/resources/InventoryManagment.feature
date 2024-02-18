Feature:

  Narrative:
  As a Warehouse keeper
  I want to keep track of my inventory
  So that I always have accurate info about products stock

  Scenario: defining new empty inventory
    Given I want to add new following inventory
      | product | unitPrice | available |
      | iphone  | 1100.0    | false     |
    When I try to define this inventory
    Then the inventory should be created
    And it should be empty
