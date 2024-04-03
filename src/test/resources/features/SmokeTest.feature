# In the feature file we can group our test by using @Smoke which we can run them specifically from our test runner class! @Smoke is a case sensitive, and also can be assigned to specific scenario
# or if it is mentioned above Feature: it will make the entire feature file class Smoke including the scenarios!
# @Smoke make multiple feature file into one group when it is tag is applied in on those feature files.
# If we want to run a specific feature file from a scenario we can use the Tag @Smoke above that scenario, it will only execute that scenario for us!
@Smoke
Feature: Major Functionalities for Smoke Test
# Hook is already setup which will open and close browser, and the only line we need here is the validation of the title!
  @Story_1
  Scenario: Validate Home page title.
    Then Validate top Left corner is "TEKSCHOOL"
    @Story_2
    Scenario: Validate Home page title and sign in button
      Then Validate top Left corner is "TEKSCHOOL"
      Then Validate Sign In Button is Enabled


