package tek.bdd.pages;

import org.openqa.selenium.By;

public class SignUpPage {
// It is a good practice to locate all the locators at once then proceed!
// NOTE: The name of of By locator has to be in all Caps!
    public static final By NAME_INPUT = By.name("name");
    public static final By EMAIL_INPUT = By.name("email");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By CONFIRM_PASSWORD_INPUT = By.name("confirmPassword");
    public static final By SIGN_UP_BUTTON = By.id("signupBtn");
}
