Feature: Patient Login

Scenario: Login as patient
	Given I am logging in as a patient
	And I input a username of Mkress
	And I input a password of 12345ABCDe
	When I login as a patient
	Then I am back on the home page logged in
