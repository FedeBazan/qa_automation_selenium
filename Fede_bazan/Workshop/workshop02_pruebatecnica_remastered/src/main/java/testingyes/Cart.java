package testingyes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart extends Base {

    By sectionArticleClass = By.className("cart-item");
    By proceedToCheckOutBtmlinkText = By.linkText("Proceed to checkout");
    By proceedToCheckOutBtmXpath = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a");

    public Cart(WebDriver driver) {
        super(driver);
    }

    public boolean  addedCheclArticle(){
        return findElement(sectionArticleClass).isDisplayed();
    }

    public void  clickOnProceedToCheckBtm(){
        clickOnElement(proceedToCheckOutBtmXpath);
    }
}
