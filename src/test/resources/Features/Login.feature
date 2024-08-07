#Author: your.email@your.domain.com
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
##@tag
#Feature: Title of your feature
 # I want to use this template for my feature file

 # @tag1
 # Scenario: Title of your scenario
 # Given I want to write a step with precondition
 #   And some other precondition
 #   When I complete action
 #   And some other action
 #   And yet another action
 #  Then I validate the outcomes
 #  And check more outcomes

#  @tag2
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#   Then I verify the <status> in step

#    Examples: 
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |



Feature: Login functionality
Background: 
Given user should be login page


Scenario: TC_01_valid login
When user enter the valid credential
Then user should be navigated to home page
And user can see the logout link


Scenario: TC_02_invalid login
When user enter the invalid credential
Then user can see the error message



  #data deriven hai isliye humne excel mai sirf tc nsme pass kiya
@deepa
Scenario Outline: TC_03_invalid login  multiple data credential
When user enter the invalid userid as "<userid>" and password is "<password>"
Then user can see the error message
Examples:

|userid | password|
|ad1    | pwd1    |
|ad2    | pwd2    |
|ad3    | pwd3    |



      