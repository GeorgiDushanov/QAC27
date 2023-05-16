import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void SetUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    public static void setWait(){
        wait=new WebDriverWait(driver,Duration.ofSeconds(3));

    }

    public static void CloseDr(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
