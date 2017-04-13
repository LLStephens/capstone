Feature: Doctor Login

Scenario: Login as Doctor
	Given I am logging in as a doctor
	And I input a doctor username of Drjohn
	And I input a doctor password of doctorNUmber1
	When I login as a doctor
	Then I am transferred to the doctor portal