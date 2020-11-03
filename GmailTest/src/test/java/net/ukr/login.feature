@login
Feature: Login to the email

  Background:
    Given Login page is open

  @success @all
  Scenario: successful login on main page
    When I enter valid login "tigrina.pitonovna"
    And I enter valid password "n0n0n0y9s"
    And I click btn
    Then page redirects me to my inbox

  @fail @all
  Scenario Outline: unsuccessful login on main page
    When I enter login <login>
    And I enter password <password>
    And I click btn
    Then system returns an error
    Examples:
      | login                | password     |
      | "tigrina .pitonovna" | "n0n0n0y9s"  |
      | "tigrina.pitonovna"  | "n0n0n0y9s " |
      | "tigrina.pitonovna " | "n0n0n0y9s"  |
      | "tigrina.pitonovna1" | "n0n0n0y9s"  |
      | "tigrinapitonovna"   | "n0n0n0y9s"  |
      | "tigrina.pitonovna"  | "N0n0n0y9s"  |
      | "tigrina.pitonovna"  | " n0n0n0y9s" |



