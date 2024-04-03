package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.HomePage;
import tek.bdd.utility.SeleniumUtilities;

public class SmokeTestSteps extends SeleniumUtilities {

    @Then("Validate top Left corner is {string}")
    public void validateTopLeftCorner(String expectedTitle) {
// Since the BY locator is defined in the HomePage for Homepage elements. In this line of code we are replacing this "By locator" to "HomePage.TOP_NAV_LOGO" to use those properties here!
// We are able to call it directly, since it is set to static that allows us to add it manually.
    String actualTitle = getElementText(HomePage.TOP_NAV_LOGO);
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("Validate Sign In Button is Enabled")
    public void validateSignInButtonIsEnabled() {
        boolean isButtonEnable = isElementEnabled(HomePage.SIGN_IN_BUTTON);
        Assert.assertTrue(isButtonEnable);

    }
}
