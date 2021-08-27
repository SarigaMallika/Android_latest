Feature: Validation on Your profile page positive test cases

  #User should be able to click on the your profile and edit profile details
  Scenario: Validate that the  Your Profile  title  should be present in  Your Profile screen
    Given App is open
    When Enter login data
    Then check Your Profile  title  should be present in  Your Profile screen

  Scenario: Verify the scenario when dialogue box will appear, when click on edit icon
    Given Click on edit icon
    When Verify the dialogue box
    Then Add OTP and password

  Scenario: Verify the scenario when edit  the profile details
    Then Edit  the profile details

  Scenario: Verify the scenario when add Email ID in contact details
    And Add Email ID in contact details

  Scenario: Verify the scenario when Activate , Edit and  Deactivate Email ID
    When Activate , Edit and  Deactivate the Email ID

  Scenario: Verify the scenario when add Phone Number in contact details
    Then Add Phone Number in contact details

  Scenario: Verify the scenario when Activate , Edit and  Deactivate the Phone Number
    Then Activate , Edit and  Deactivate the Phone Number

  Scenario: Verify the scenario when add Address in contact details.
    Then Add Address in contact details.

  Scenario: Verify the scenario when Activate , Edit , Primary and  Deactivate the Address
    Then Activate , Edit , Primary and  Deactivate the Address

  Scenario: Verify the scenario when add Plan coverage
    Then Add Plan coverage

  Scenario: Verify the scenario when Activate , Edit , Make primary and  Deactivate the Plan coverage
    Then Activate , Edit , Make primary and  Deactivate the Plan coverage

  Scenario: Verify the scenario when changing the password
    Then Change the password

  Scenario: Verify the scenario when password should be displayed on clicking the eye and user can able to save the details
    Then The password should be displayed on clicking the eye
