Feature: Validation on Utilities page negative test cases

  #User should be able to click on the Utilities tab and able to use all the services under Utilities
  Scenario: Navigate to Utilities screen
    Given user is on home page
    When clicks on Utilities tab
    Then Navigate to Utilities Dashboard

  Scenario: Click options provided in left side navigator
    When Click on left side navigator options

  Scenario: Verify that click on all the Tiles in the Utilities dashboard
    When Click all tiles in utilities dashboard

  Scenario: Add card details  in the Wallet dashboard
    When Enter card details in wallet dashboard
    Then Verify card details is saved

  Scenario: Add bank details  in the Wallet dashboard
    When Enter bank details in wallet dashboard
    Then User should able to click on Deactivate tile
   
   
    Scenario: Validate user can click on Award points and able to view Balance and Your award point history.
    Given Click Award Points
    When Navigate to Award Points screen
    Then view the Balance, award points history and Welcome bonus text.

  Scenario: Validate that user is able to view Award points dashboard details.
    Given Redeem button enabled
    When Click on Award Redeem button
    Then view the Available award points, Award points to reedem, and email id.

  Scenario: Validate that user is able to redeem points  in the Award points dashboard.
    Given Select Amazon gift card
    And Enter Amount 20
    When Click on 'More information about the gift card' link
    Then A pop up will appear with title 'Reward description'. Validate the text and click OK button
    And Click on 'Redeem' button, Navigate to the redeem page and validate the page title.

  Scenario: Validate that the user is able to navigate to the Redeemed page
    Given view the You have redeemed 2000 points and You have availed this gift card text.
    When Click on Redeem More Points button. Navigated to Redeem award points dashboard.
    Then Click on Go to Award Points Dashboard button. Navigated to Award points dasboard.
    And Verify Your award Points history and balance.
   

  