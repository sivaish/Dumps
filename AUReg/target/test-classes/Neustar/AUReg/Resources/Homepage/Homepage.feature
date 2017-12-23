#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Test AUREGISTERY

  Background: 
    Given Open auregistery in chrome driver

  @S01
  Scenario: To check the no of domains registered
    Then I get the no of registered domains
    And I check the total number is greater than 3 billion

  @S02
  Scenario: Domain availability check
    When I open the domain availability page
    Then I enter the .com.au domain name and verify
    Then I enter the .org.au domain name and verify


  @S03
  Scenario: Registrar count and validate the
    When I open the Registrar page
    Then I get the count of external links
    And I Become a Registrar and verify the page
