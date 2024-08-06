Feature: lead functionality
Background:
Given user should be login page
When user enter the valid credential


@only
Scenario: TC_04_create lead
When user fill the mandatory fileds as "<lname>" and  "<Comp>"
|lname | Comp |
|ad1   | pwd1 |
|ad2   | pwd2 |
|ad3   | pwd3 |
|ad4   | pwd4 |
Then lead should be created successfully
And click on logout

