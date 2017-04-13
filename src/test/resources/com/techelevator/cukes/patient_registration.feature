Feature: Patient Registration

Scenario: Register as patient
	Given I am registering as a new patient
	And I enter a name of Joe
	And I enter a date of birth of 05/04/1970
	And I enter an address of 1234 Address
	And I enter a phone number of 614-555-5555
	And I enter an email of joe@gmail.com
	And I enter a user name of joe
	And I enter a password of Password123
	And I confirm the password with Password123
	When I create a user
	Then I am directed to the login page	