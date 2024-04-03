@Regression
Feature: Retail app security test feature.
  #Cucumber has another feature called "Background" background says if you have a same step in the beginning of each scenario you can place it in the background which will run it before each scenario!
  # Don't get yourself confuse with Hook! Hook will always run first! Then in each scenario if a first steps is duplicated to another scenario we can place it in the background!
  # In the below "When User click on Sign In Button" is being repeated!
  Background: Description about the background
    Given User click on Sign In Button

    #Story (1)
  @Security_Positive
  Scenario Outline: Validate valid username and password credential
    When User enter "<username>" and "<password>" and click on Login
    Then User will see Account button on home page.

    #Lets if we are prompted to test the above scenario with another account how do we approach it?
    # We can create another Scenario as above, but that would be a duplication! So we go with "Scenario Outline" way which we can pass the parameter which in this case is Username and Password!
    # This is how the implementation looks like.
    # This is how we parameterized "<Value>" we can have one or more!
    # NOTE: It is a good practice to pass the parameters just if we have to test with more data for the same action!

    Examples:
      | username                     | password    |
      | mohammad_osprey@tekschool.us | 12345678Ab@ |
      | mansoor@gmail.com            | Ruya@2014   |


    # Story 2 : (SecurityTest.feature) Navigate to sign in page and sign in with invalid username and valid password. Validate error message displays "wrong username or password"
    # Story 2 : (SecurityTest.feature) Navigate to sign in page and sign in with valid username and invalid password. Validate error message displays "wrong username or password"
    # These Stories above have same steps the only thing that changes is the data we input! So in this case it is best to use Scenario Outline!
  @Security_Negative
  Scenario Outline: Validate Sign in with Invalid Credentials
    When User enter "<username>" and "<password>" and click on Login
    Then Validate error message "<errorMessage>"
    Examples:
      | username          | password      | errorMessage               |
      | Wrong@gmail.com   | 12345678Ab@   | wrong username or password |
      | mansoor@gmail.com | wrongPassword | wrong username or password |
      | Wrong@gmail.com   | wrongPassword | wrong username or password |