package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.AccountProfilePage;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.LoginPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.DataGeneratorUtility;
import tek.bdd.utility.SeleniumUtilities;

import java.util.List;
import java.util.Map;

public class CreateAccountSteps extends SeleniumUtilities {
//We will be facing another issue, if we only assign the Random class from DataGeneratorUtility to @When("User fill Form {string} and {string} and {string}") method! we also need to validate
// in @Then("Validate {string} and {string} in account page") method! To fix this issue, we must do the following:
//        1) Create an instance variable and set it private so only CreateAccountSteps can have access to that variable!
//        2) We will store DataGeneratorUtility.randomEmail(email); which we called into it!
//        3) Since the information is now stored into the generatedRandomEmail, we can call that instead to validate our random email!
//        4) We will no longer need the expected email from the feature file instead we can use the generatedRandomEmail!


    private String generatedRandomEmail;

//NOTE: @Given User click on Sign In Button || This step has already been applied in the background which is not required to repeat in the step definition, but has to be mentioned in Feature Files!
    @Given("User click on Create Account")
    public void user_click_on_create_account() {
        clickElement(LoginPage.CREATE_ACCOUNT_LINK);
    }
//  """@CreateNewAccount"""
//  #NOTE: FROM "@CreateNewAccount" ALL THE WAY TO "@CreateNewAccount_5" ARE DIFFERENT APPROACHES TO FILL UP A FORM! FROM "PARAMETERS>MAP>LIST>MAPS>LISTS"
    @When("User fill Form {string} and {string} and {string}")
    public void user_fill_form_and_and(String name, String email, String password) {
//  We are importing the method from DataGeneratorUtility Statically since need it to randomly generate different email everytime we create an account!
//  NOTE: We are passing "generatedRandomEmail" to all the placed we have mentioned just email! And to remember, this email is originally coming from "Feature File" and it could be anything! @ sign is unique in every email it won't change!
        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT,password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }
//   """@CreateNewAccount_2""" With the use of Data table "MAP"!        A good approach for "Filling Up Form"
    @When("User fill up Sign up Form")
    public void user_fill_up_sign_up_form(DataTable dataTable) {
    // Step 1) Converting Data Table to Map!
        Map<String, String> data = dataTable.asMap();  //  Code Explanation: We are setting the "dataTable" as "Map" which return Map of <String, String>
    //  Here we are simply getting the email, name and password by the use of "data" and storing them into a "String"
        String email = data.get("email");
        String name = data.get("name");
        String password = data.get("password");

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT,password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }
//   """@CreateNewAccount_3""" With the use of Data table "List"! A good approach for checking/confirming a form header!
    @When("User fill up Sign up Form With List Data Table")
    public void user_fill_up_sign_up_form_with_list_data_table(DataTable dataTable) {
        // Step 1) Converting Data Table to List!
        List<String> data = dataTable.asList();  //Code Explanation: We are setting the "dataTable" as "List" which return List of <String>
        // Since we have mentioned that when we use Data Table as List, the way we retrieve info by the index location and " IT HAS TO BE IN THE RIGHT ORDER" ! We are relying in the order of the data!
        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT,password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }
//   """@CreateNewAccount_4""" With the use of "List of Maps" Data Table!
    @When("User fill up Sign up Form With List of Map Data Table")
    public void user_fill_up_sign_up_form_with_list_of_map_data_table(DataTable dataTable) {
        // Step 1) Converting Data Table to "List of Maps"
       List<Map<String, String>> data = dataTable.asMaps();
       // Each row of the List is a Map! Extract first row Data! || If we have more than a one row we can use the Loop to iterate and get retrieve our data!
        Map <String, String > dataMap = data.get(0);

        String email = dataMap.get("email");
        String name = dataMap.get("name");
        String password = dataMap.get("password");

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT,password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }
//   """@CreateNewAccount_5""" With the use of "List of Lists" Data Table!
    @When("User fill up Sign up Form With List of List Data Table")
    public void user_fill_up_sign_up_form_with_list_of_list_data_table(DataTable dataTable) {
        // Converting data table to list of List asLists().
        List<List<String>> rawData = dataTable.asLists();
        //Each
        List <String> data = rawData.get(0);

        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);
        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT,password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }



    @When("User Click on Sign up button")
    public void user_click_on_sign_up_button() {
    clickElement(SignUpPage.SIGN_UP_BUTTON);
    }

    @Then("User will navigate to Account Profile Page")
    public void user_will_navigate_to_account_profile_page() {
//  isDisplayed will return us a boolean, so it has to be stored in boolean followed by the name isDisplayed!
//  Right after we are validating this by the use of Assert which comes from jUnite!
       boolean isDisplayed = isElementDisplayed(AccountProfilePage.YOUR_PROFILE_TEXT);
        Assert.assertTrue(isDisplayed);
    }
// Here we have to compare two texts which is name and email! || NOTE: Every step we test we need to validate!
    @Then("Validate {string} and email in account page")
//  Here we change the name from name and email to expected name and expected email for better understanding, and also to differentiate between the two!
//  Here we are using generatedRandomEmail to validate the email that is why we have removed the second string .
    public void validate_and_in_account_page(String expectedName) {
//  This is coming from the website, so we will name it actualName to store that value from the website into the String and compare it with the use of Assert!
       String actualName = getElementText(AccountProfilePage.PROFILE_NAME_TEXT);
       Assert.assertEquals(expectedName, actualName);
//  This is coming from the website, so we will name it actualEmail to store that value from the website into the String and compare it with the use of Assert!
       String actualEmail = getElementText(AccountProfilePage.PROFILE_EMAIL_TEXT);
       Assert.assertEquals(generatedRandomEmail, actualEmail);
    }
}
