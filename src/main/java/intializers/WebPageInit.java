package intializers;

import com.aventstack.extentreports.ExtentTest;
import com.jcraft.jsch.JSchException;
import common.DriverFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportManagement.ExtentManager;
import utils.CommonUtils;

import java.time.Duration;

public class WebPageInit {
    protected ExtentTest pageInfo;
    protected static WebDriver webdriver;

    public WebPageInit()  {
        webdriver= DriverFactory.getDriver();
        CommonUtils.pauseExecution(5);
        PageFactory.initElements(webdriver,this);
        webdriver.get("https://www.amazon.in");
    }
    public boolean isElementNotPresent(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(60), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void setText(WebElement element,String text,String elementName){
        pageInfo= ExtentManager.getTest();
        element.sendKeys(text);
        pageInfo.info("Entered text: '"+text +"' into field "+elementName);
    }

    protected void clickOnElement(WebElement element, String elementName) {
        pageInfo= ExtentManager.getTest();
        element.click();
        pageInfo.info("Clicked on : '"+elementName +"'");
    }
    protected void info(String elementName) throws JSchException {
        pageInfo= ExtentManager.getTest();
        pageInfo.info(elementName);
    }
}
