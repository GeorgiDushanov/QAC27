import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeSuite;

public class TestExam2 {

    @BeforeSuite
    public void setUp(){
        Browser.SetUp();
    }
    @org.testng.annotations.Test
    public void Testing() {
        GetPage.goTo();
        GetPage.ClickMyAccount();
        GetPage.ClickRegister();
        RegisterForm.FirstName(RandomStringUtils.randomAlphabetic(5));
        RegisterForm.LastName(RandomStringUtils.randomAlphabetic(8));
        RegisterForm.email();
        RegisterForm.phoneNumber(RandomStringUtils.randomNumeric(10));
        RegisterForm.passWord("parola!123");
        RegisterForm.confirmPassword("parola!123");
        RegisterForm.clickCheckbox();
        RegisterForm.clickContinue();
        RegisterForm.verifyText();
    }

}
