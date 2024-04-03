package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseSetup {
    // We wanted to share the drive to all other child classes! || This is an instance variable for no value is assigned to it!

    /*How can we use cross-browsing?? Meaning, how we can run our code in different browsers! Edge, Chrome FireFox etc...
    * First, we are going to create a String name browserType for now we can initial it to chrome!
    * Then we create a list of selections with the use of: if, an elseif and else statement which now whenever we change browserType to our code, will be run through that browser!
    * In the end, if none of these browsers are used or if something else is used! We are throwing a runtimeException that the wrong browser type is being used!
     */
    private static WebDriver driver;
    private final Properties properties = new Properties();

    //Constructor
    public BaseSetup() {
    // We have created this BaseSetup, so we can move all of our config to "config.properties" class, so we would be able to use this code for other application and browser!
        // To read a Properties file, we need the following:
        // 1) File in System. || Location of this file: resources>config>application-config.properties
        // 2) FileInputStream.
        // 3) Object of Properties Class.

        // Importing File from "application-config.properties"
        //Added try/catch blog to hand the compile time exception!
        try {
            // System.getProperty("user.dir") return location of Project in your machine than we have to append the rest of the location from Project where the config.properties located at!
            // This is one of the ways to read a file from Java class!
            String fileFilePath = System.getProperty("user.dir") + "/src/test/resources/config/application-config.properties";
            // Creating a copy of "File" class with for the parameters we are passing (fileFilePath)
            File propertiesFile = new File(fileFilePath);
            // creating an object of "FileInputStream" which take a parameter of File, so we are passing propertiesFile! We are getting Compile time exception!
            FileInputStream propertyFileInputStream = new FileInputStream(propertiesFile);

            properties.load(propertyFileInputStream);
//          Here we are adding Runtime exception if the filepath is not correct other scenarios!
        } catch (IOException ex) {
            throw new RuntimeException("Can not read or load config file " + ex.getMessage());
        }

    }
    public void openBrowser(){
// Read a browser type from properties file
    String browserType = this.properties.getProperty("retail.browser.type");
// (this.properties.getProperty("retail.browser.headless")) this is returning String but the "Headless" takes true and false values,
// so we have to convert it to boolean with the use of Boolean.parseBoolean and store it inside a boolean with your desire name.
     boolean isHeadless = Boolean.parseBoolean(this.properties.getProperty("retail.browser.headless"));
    if (browserType.equalsIgnoreCase("chrome")) {
        ChromeOptions options = new ChromeOptions();  //  Creating ChromeOption Object to customize the chrome browser!
        if (isHeadless) options.addArguments("--headless"); // using if statement to pass the argument if we set it to "headless mode"
        driver = new ChromeDriver(options); // Here we are passing the option as a parameter to run it as "headless" if it set to run in headless mode!

    }else if (browserType.equalsIgnoreCase("edge")) {
        EdgeOptions options = new EdgeOptions();
        if (isHeadless) options.addArguments("--headless");
        driver = new EdgeDriver(options);

    }else if (browserType.equalsIgnoreCase("firefox")) {
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless) options.addArguments("--headless");
        driver = new FirefoxDriver(options);

    }else {
        throw new RuntimeException("Wrong browser Type");
    }

        driver.manage().window().maximize();
    // Get URL from property file and store inside a String name url, and then instead of having the url hard coded we can just get(url) from property folder ....
        String url = this.properties.getProperty("retail.ui.url");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
// Created A "Getter" Method in the Base class to it can be called in Other classes!
    public WebDriver getDriver() {
        return driver;
    }
}
