Feature: Search for IT Job

Scenario: Search For QA Test Automation Job

Given User Will Open Chrome Driver And Browse to URL= "https://www.labcorp.com/"
When User Clicks on Career Link
And EnterText "QA Test Automation Developer" in the Search Box
And User Will Get Job Tittle,Job Location and Job Id of QA Developer


Then User Will Validate Job Tittle="QA Test Automation Developer",Job Location="Durham, North Carolina, United States of America" and Job Id="Job Id : 21-90223_RM"
And User Will Validate Required Knowledge="Prepare test plans, budgets and schedules",Required Years="5+ years of experience in QA automation development and scripting",Required Skills="5+ years of experience in developing sub-UI and UI based scripts with tools like Selenium, RIT, Visual Studio, UFT, custom code, and more"
When User Clicks on Apply Now Button 
Then User Will Return Job Search and Click

