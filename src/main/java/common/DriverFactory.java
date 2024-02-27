package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }


    public static WebDriver createDriver() {

        System.setProperty("webdriver.safari.driver", "driver/chromedriver");

        ChromeOptions options = new ChromeOptions();

        // Add desired options
        options.addArguments("--start-maximized"); // Example: Start Chrome maximized
        options.addArguments("--disable-extensions"); // Example: Disable browser extensions
        //options.setHeadless(true); // Example: Run Chrome in headless mode

        // Set experimental option
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Example: Exclude automation switch
        return driver = new ChromeDriver(options);

    }



    public static void closeDriver(){
        driver.quit();
    }

    public static void main(String[] args) {
        createDriver();
    }

}
