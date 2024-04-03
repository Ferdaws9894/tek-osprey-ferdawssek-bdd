package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.LoginPage;
import tek.bdd.utility.SeleniumUtilities;

public class SecurityTestSteps extends SeleniumUtilities {

    @Given("User click on Sign In Button")
    public void userClickOnSignInButton() {
    clickElement(HomePage.SIGN_IN_BUTTON);
    }
// Since we are passing the username and password as parameters, they must set them to {string} with lowercase "s" for that is how Cucumber will read it!
    // These strings will pass the data based on the order we have input. If username is set to first string it will retrieve username from "feature file" and same concept for password!
    // In our method public void, we are pass that String which is java. So we are getting from Cucumber and passing it to java and we declare the String with name: Example: String username
    @When("User enter {string} and {string} and click on Login")
    public void userEnterCredentialsAndClickLogin(String username, String password) {
    sendTextToElement(LoginPage.EMAIL_INPUT, username);
    sendTextToElement(LoginPage.PASSWORD_INPUT, password);

    clickElement(LoginPage.LOGIN_BUTTON);
    }

    @Then("User will see Account button on home page.")
    public void userWillSeeAccountButtonOnHomePage() {
        boolean isDisplayed = isElementDisplayed(HomePage.ACCOUNT_LINK);
        Assert.assertTrue(isDisplayed);
    }
    @Then("Validate error message {string}")
    public void validateErrorMessage(String expectedErrorMessage) {
        String actualError = getElementText(LoginPage.ERROR_MESSAGE);
        Assert.assertEquals(expectedErrorMessage, actualError);
    }
}
