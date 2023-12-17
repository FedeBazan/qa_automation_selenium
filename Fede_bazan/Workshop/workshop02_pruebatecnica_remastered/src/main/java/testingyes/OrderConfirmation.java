package testingyes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmation extends Base {

    private By msgConfirmOrderXpath = By.xpath("//*[@id=\"content-hook_order_confirmation\"]/div/div/div/h3");
    public OrderConfirmation(WebDriver driver) {
        super(driver);
    }

    public String checkBuyMsg(){
        return getText(msgConfirmOrderXpath);
    }

}
