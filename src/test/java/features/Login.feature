Feature: Login Page
#below line is for single test execution with single data
#Scenario: Validate login page with invalid credentials
#below line is for single test execution with multiple inputs
Scenario Outline: Validate login page with invalid credentials 
Given Initialize browser driver with chrome
And Hit URL "http://www.qaclickacademy.com/"
And Click on home page login in link
#When User enter username "vaibhav.medhekar40@gmail.com" and password "12345" -- this is for passing value to stepdef file
When User enter <username> and <password>
Then Verify that user is successfully logged in
And close browsers

Examples:
|username					 |password	|
|vaibhav.medhekar40@gmail.com|12345		|
|xyz@qaclick.com			 |123456	|