@PageDynamic
Feature: Explicit wait


  Scenario: User try to check dynamic element page
    Given User is on the The internet page
    And User click "Dynamic Loading"
    Then User go to Dynamic page "Example 2: Element rendered after the fact"
    And User click start button
    Then User wait until page load to see "Hello World!"