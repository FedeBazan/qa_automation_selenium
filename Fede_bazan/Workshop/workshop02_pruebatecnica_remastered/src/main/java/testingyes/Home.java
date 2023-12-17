package testingyes;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home extends Base {

    private By headerElementID = By.id("header");
    private By elementImgXpath = By.xpath("//*[@id=\"content\"]/section/div/article[1]/div/a/img");

    public Home(WebDriver driver) {
        super(driver);
    }

    public WebElement IsDisplayedheader(){
        return findElement(headerElementID);
    }

    public void watchTheElement(){
        clickOnElement(elementImgXpath);
    }

}
