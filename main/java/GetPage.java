import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetPage {

    @FindBy(xpath ="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
    private static WebElement MyAccount;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private static WebElement Register;
    private static String webpage="http://shop.pragmatic.bg/";

    static {
        PageFactory.initElements(Browser.getDriver(), GetPage.class);
    }

    public static void goTo() {
        Browser.getDriver().get(webpage);
    }
    public static void ClickMyAccount(){
        MyAccount.click();
    }

    public static void ClickRegister(){
        Register.click();
    }
}
