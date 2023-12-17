package testingyes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {

    WebDriver driver;
    JavascriptExecutor js;
    public Base(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }
    public void clickOnElement (By locator){
        driver.findElement(locator).click();
    }

    public void sendKeys (By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public void scrollTo (By locator){
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public WebElement findElement (By locator){
        return driver.findElement(locator);
    }
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

}
