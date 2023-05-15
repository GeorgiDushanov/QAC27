import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BuyAsGuest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://shop.pragmatic.bg");
    }

    @Test
    public void BuyAsGuest() {
        WebElement Item= driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[1]/a/img"));
        Item.click();
        WebElement Cart= driver.findElement(By.id("button-cart"));
        Cart.click();
        WebElement CartButt = driver.findElement(By.xpath("//*[@id=\"cart-total\"]"));
        CartButt.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")));
        WebElement Checkout= driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong"));
        Checkout.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label")));
        WebElement Guest= driver.findElement(By.xpath("//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label"));
        Guest.click();
        WebElement Continue= driver.findElement(By.id("button-account"));
        Continue.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-firstname")));
        WebElement FirstName= driver.findElement(By.id("input-payment-firstname"));
        FirstName.sendKeys("Ivo");
        WebElement LastName= driver.findElement(By.id("input-payment-lastname"));
        LastName.sendKeys("Ivaninov");
        WebElement Mail= driver.findElement(By.id("input-payment-email"));
        Mail.sendKeys("ivaninvainva2123231234070@dawadearasdwar.com");
        WebElement Phone= driver.findElement(By.id("input-payment-telephone"));
        Phone.sendKeys("01923120321334414");
        WebElement Address= driver.findElement(By.id("input-payment-address-1"));
        Address.sendKeys("dad1232345332131 34214211424451513 ");
        WebElement City= driver.findElement(By.id("input-payment-city"));
        City.sendKeys("Burgas");
        WebElement PostalCode= driver.findElement(By.id("input-payment-postcode"));
        PostalCode.sendKeys("8989");
        WebElement CountryDropDown= driver.findElement(By.id("input-payment-country"));
        Select countrySelect=new Select(CountryDropDown);
        countrySelect.selectByValue("33");

        WebElement cityDropDown = driver.findElement(By.id("input-payment-zone"));
        Select citySelect = new Select(cityDropDown);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='input-payment-zone']/option[@value='505']")));
        citySelect.selectByValue("505");

        WebElement Continue1 = driver.findElement(By.xpath("//*[@id=\"button-guest\"]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-payment-zone\"]/option[3]")));
        Continue1.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        WebElement DeliveryMethod= driver.findElement(By.id("button-shipping-method"));
        DeliveryMethod.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"button-payment-method\"]")));
        WebElement Continue3= driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]"));
        driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")).click();
        Continue3.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));
        WebElement Confirm= driver.findElement(By.id("button-confirm"));
        Confirm.click();

        WebElement Text= driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        Assert.assertEquals(Text.getText(),"Your order has been placed!");
















    }
}
