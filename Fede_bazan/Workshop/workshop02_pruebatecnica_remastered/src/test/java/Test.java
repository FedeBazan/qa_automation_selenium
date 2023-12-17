import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import testingyes.*;

public class Test {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.testingyes.com/onlineshop/");
        driver.manage().window().fullscreen();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @org.testng.annotations.Test
    public void testConnection(){
        Home home = new Home(driver);
        Assert.isTrue(home.IsDisplayedheader().isDisplayed(), String.valueOf(true));
    }

    //Ver articulo
    @org.testng.annotations.Test
    public void watchElement(){
        Home home = new Home(driver);
        Article article = new Article(driver);
        home.watchTheElement();
        article.checkImgElement();
    }

    //Agregar al carrito
    @org.testng.annotations.Test
    public void addArticle() throws InterruptedException {
        String expectedMsg= "\uE876Product successfully added to your shopping cart";
        watchElement();
        Article article = new Article(driver);
        String actualMsg=article.clickOnAddAndCheckToCart();
        org.testng.Assert.assertEquals(actualMsg,expectedMsg);
    }

    //Ver el carro de compras
    @org.testng.annotations.Test
    public void watchCart() throws InterruptedException {
        addArticle();
        Article article = new Article(driver);
        Cart cart = new Cart(driver);
        article.clickOnBtmProceedToCheckOut();
        org.testng.Assert.assertTrue(cart.addedCheclArticle());
    }

    //Completar formulario

    // completar datos de cliente
    @org.testng.annotations.Test
    public void completeFormUserValues() throws InterruptedException {
        watchCart();
        Cart cart = new Cart(driver);
        Order order = new Order(driver);
        String name = "Julio Pablo Federico";
        String lastname = "Bazan";
        String email = "testeantetesteadortesteando@gmail.com";
        String comnpany = "Zangusheria Milanga Corporeyshion";
        String address = "In the Messi's hearth";
        String city = "En la ciudad de la furia";
        String zCode = "45315";
        String deliveryMsg = "A veces el perro muerde, pero si corres muerde mas fuerte";
        cart.clickOnProceedToCheckBtm();
        order.completeFormPersonalInformation(name,lastname,email);
        order.completeFormAdressInformation(comnpany,address,city,zCode);
        order.completeDeliveryComment(deliveryMsg);
    }

    //comletar datos de pago

    @org.testng.annotations.Test
    public void completeValuesPayment() throws InterruptedException {
        completeFormUserValues();
        Order order = new Order(driver);
        order.completePayment();
    }

    //confirmar pago
    @org.testng.annotations.Test
    public void checkSuccessfullPay() throws InterruptedException {
        completeValuesPayment();
        String expectedMsg = "\uE876YOUR ORDER IS CONFIRMED";
        OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
        org.testng.Assert.assertEquals(orderConfirmation.checkBuyMsg(),expectedMsg);
    }
}

