package tek.bdd.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtilities extends BaseSetup {


    private WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait;
    }

    // Create A method "clickElement" that take By
    // object and click on an element
    public void clickElement(By locator){
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getElementText(By locator) {
        String text = getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        return text;
    }

    public boolean isElementEnabled(By locator) {
        boolean isEnabled = getWait().until(ExpectedConditions.presenceOfElementLocated(locator)).isEnabled();
        return isEnabled;
    }

    public void sendTextToElement(By locator, String text) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public boolean isElementDisplayed(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

}
