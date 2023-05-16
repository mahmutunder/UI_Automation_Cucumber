@multiple
Feature: Make multiple

  Scenario: Go page mame drop-down multiple options
    Given User already in the to  "Dropdown" page
    And User send JS tto change multiple option
    Then User see more option to chose
