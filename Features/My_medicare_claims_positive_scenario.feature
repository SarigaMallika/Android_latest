Feature: Claims page positive scenarios
​
  Scenario: Validate that the user is able to launch the application
    Given Launch the app
​
  Scenario: Validate that the user is able to navigate to Claims screen
    When Clicks on the Circles and select my medicare
    Then Click on Claims from the My Medicare dashbord
​
  Scenario: Verify the scenario when Claims title and back arrow visible on the page
    When Claims title and back arrow are displayed
​
  Scenario: Verify the scenario when select Claim type from the dropdown field
    Then select Claim type from the dropdown field
​
  Scenario: Verify the scenario when select Time period from the dropdown field
    Then select Time period from the dropdown field
​
  Scenario: Verify the scenario  to view 'Patient portion and Insurer portion' under claims summary
    When Patient portion and Insurer portion are displayed
​
  Scenario: Verify the scenario  to view 'Here is the helpful breakdown' text under Claims summary
    Then Here is the helpful breakdown text is displayed
​
  Scenario: Verify the scenario claims breakdown under 'Here is the helpful breakdown' text
    When the claims category under Here is the helpful breakdown text
​
  Scenario: Verify the scenario to sort claims under 'Claims' tab
    Then Click on funnel icon and sort Date created portion
​
  Scenario: Verify the scenario to view total number of claims
    When total number of claims are displayed
​
  Scenario: Verify the scenario to select one claim under the list of claims
    Then select one claim under the list of claims
​
  Scenario: Verify the scenario when selected claim service details can be visible
    Then service details is displayed
​
  Scenario: Verify the scenario to click on related records
    Then related records under claims is displayed
​
  Scenario: Verify the scenario to click on More icon
    Then click on More icon