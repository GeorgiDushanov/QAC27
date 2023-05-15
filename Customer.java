import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Customer {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://shop.pragmatic.bg/admin");
    }

    @Test
    public void CreateCustomer(){
        WebElement UsernameField= driver.findElement(By.id("input-username"));
        UsernameField.sendKeys("admin");
        WebElement PasswordField= driver.findElement(By.id("input-password"));
        PasswordField.sendKeys("parola123!");
        WebElement Login= driver.findElement(By.className("btn-primary"));
        Login.click();
        WebElement CustomersMenu=driver.findElement(By.xpath("//*[@id=\"menu-customer\"]/a"));
        CustomersMenu.click();
        WebElement Customers=driver.findElement(By.xpath("//*[@id=\"collapse5\"]/li[1]/a"));
        Customers.click();
        WebElement AddCustomer = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a"));
        AddCustomer.click();
        WebElement FirstName= driver.findElement(By.id("input-firstname"));
        FirstName.sendKeys("Ivo");
        WebElement LastName= driver.findElement(By.id("input-lastname"));
        LastName.sendKeys("Ivovanov");
        WebElement Email=driver.findElement(By.id("input-email"));
        String Emailname=RandomStringUtils.randomAlphabetic(10);
        String host= RandomStringUtils.randomAlphabetic(10);
        String Randomemailcrate=Emailname+"@"+host +".com";
        Email.sendKeys(Randomemailcrate);
        WebElement Telephone= driver.findElement(By.id("input-telephone"));
        String randomtel= RandomStringUtils.randomNumeric(10);
        Telephone.sendKeys(randomtel);
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("Parola456!");
        WebElement PassConfirm= driver.findElement(By.id("input-confirm"));
        PassConfirm.sendKeys("Parola456!");
        WebElement Save= driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/button/i"));
        Save.click();
        WebElement Filter=driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        Filter.sendKeys(Randomemailcrate);
        WebElement FilterButt=driver.findElement(By.xpath("//*[@id=\"button-filter\"]"));
        FilterButt.click();
        Assert.assertTrue(Customers.isDisplayed());


    }

}
