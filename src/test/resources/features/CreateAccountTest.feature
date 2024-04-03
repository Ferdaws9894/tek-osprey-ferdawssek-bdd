@Regression @CreateAccount
  #When Feature File is created, we must not add any space before placing the colon ':' which will cause failure!
Feature: Create New Account Page
#Story (4) From OneNote
  # The below is Tag "@CreateNewAccount" which we use to run a specific test! || We can go to TestRunner and set Tag = "@CreateNewAccount" which will execute this task only!
  #NOTE: FROM "@CreateNewAccount" ALL THE WAY TO "@CreateNewAccount_5" ARE DIFFERENT APPROACHES TO FILL UP A FORM! FROM "PARAMETERS>MAP>LIST>MAPS>LISTS"
  @CreateNewAccount
  Scenario: Create new Account with valid credential
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill Form "Mohammad" and "instructor@tekschool.us" and "123456Ab@"
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    # Since the email is generated dynamically, Random email, we cannot validate from here! Yes, we are passing the email from here, but than the code will bring changes to the email!
    Then Validate "Mohammad" and email in account page

    # Here we are passing the date in a "Map Data Table" instead passing them as parameter! There is a limit of parameter allowed in a "When" passing more than 6-8 parameters in a "when" consider bad coding!
    # In the Data Table we are passing "keys" on the left side and value to the right side! """"""""KEYS CANNOT BE DUPLICATED, BUT VALUES CAN!""""""""
    # We will call the keys which is name, email, and password in step definition and values will be retrieved from here which Feature Files!
    # We can pass as much as data in the Map data table it is unlimited!
  # "Data Table Map" A good approach for "Filling Up Form"
  @CreateNewAccount_2
  Scenario: Create new Account with valid credential Using Map Data Table
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form
      | name     | Mohammad                |
      | email    | instructor@tekschool.us |
      | password | 123456Ab@               |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "Mohammad" and email in account page

  # Same example from top, but now we are implementing a different approach which is called: " List Data Table "
  # With " List Data Table " We only have "Values"! There won't be any "Key" in it!
  # " List Data Table " as the name suggest, it is a list and it stored value based on index location! And we use the index location to retrieve the data!
# " List Data Table" A good approach for confirming the table rows!
  @CreateNewAccount_3
  Scenario: Create new Account with valid credential Using Map Data Table
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form With List Data Table
      | Mohammad                |
      | instructor@tekschool.us |
      | 123456Ab@               |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "Mohammad" and email in account page


   # If it is "List of Maps" that means we can have multiple rows of data depend on you need!
   # This Approach is very useful when your working with a table that has multiple rows of data! So loop through the row and get your values and validate
# "List of Maps" This is referring to a collection Maps where we have multiple rows of data || A good approach for Table
  @CreateNewAccount_4
  Scenario: Create new Account with valid credential Using List of Maps.
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form With List of Map Data Table
      | name     | email                   | password  |
      | John     | John@tekschool.us       | 123456Ab@ |

    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "John" and email in account page

# "List of List"
  @CreateNewAccount_5
  Scenario: Create new Account with valid credential Using List of List
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form With List of List Data Table
      | John     | John@tekschool.us       | 123456Ab@ |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "John" and email in account page