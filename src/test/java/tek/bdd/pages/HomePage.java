package tek.bdd.pages;

import org.openqa.selenium.By;

public class HomePage {

    //Constant variable POM approach!
    // Constant variable naming convention. all letter capitals and  _ underscore instead of spaces!
    // The reason it is set to final so no one can change the value!
    public static final By TOP_NAV_LOGO = By.className("top-nav__logo");

    public static final By SIGN_IN_BUTTON = By.id("signinLink");

    public static final By ACCOUNT_LINK = By.linkText("Account");


}
