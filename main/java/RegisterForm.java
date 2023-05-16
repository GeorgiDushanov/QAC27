import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterForm {
    @FindBy(id = "input-firstname")
    private static WebElement FirstNameField;

    @FindBy(id = "input-lastname")
    private static WebElement LastNameField;

    @FindBy(id = "input-email")
    private static WebElement Email;

    @FindBy(id = "input-telephone")
    private static WebElement Telephone;
    @FindBy(id = "input-password")
    private static WebElement Password;
    @FindBy(id = "input-confirm")
    private static WebElement ConfirmPassword;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    private static WebElement CheckBox;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private static WebElement ContinueButton;

    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    private static WebElement Text;

    static {
        PageFactory.initElements(Browser.getDriver(), RegisterForm.class);
    }

    public static void FirstName(String name) {
        FirstNameField.sendKeys(name);

    }



    public static void LastName(String lastname) {
        LastNameField.sendKeys(lastname);
    }

    public static void email() {
        String host= RandomStringUtils.randomAlphabetic(8);
        String Emailbody= RandomStringUtils.randomAlphabetic(5);
        String RandomMail=Emailbody + "@" + host +".net" ;
        Email.sendKeys(RandomMail);

    }

    public static void phoneNumber(String phone){
        Telephone.sendKeys(phone);

    }

    public static void passWord(String password){
        Password.sendKeys(password);

    }

    public static void confirmPassword(String confirmpassword){
        ConfirmPassword.sendKeys(confirmpassword);
    }

    public static void clickCheckbox(){
        CheckBox.click();
    }

    public static void clickContinue(){
        ContinueButton.click();
    }

    public static void verifyText(){
        Assert.assertEquals(Text.getText(),"Your Account Has Been Created!");
    }


}



