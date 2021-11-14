@kekaAutomate
Feature: Automating the keka portal for login and logout

  @kekaLogin
  Scenario: Clocking into kekaPortal in Day
    Given I am loging into keka portal with "surendiran.t@techouts.com" and "keka@automate123"
    When I press the clock-in button in home page
    Then I should be clocked-in for the day
    Then logout from the keka portal

    @kekaLogout
  Scenario: Clocking out of kekaPortal at evening
    Given I am loging into keka portal with "surendiran.t@techouts.com" and "keka@automate123"
    When I press the clock-out button in home page
    Then I should be clocked-out for the day
    Then logout from the keka portal