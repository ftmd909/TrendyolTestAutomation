import Base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    public void loginSuccessful() {
        loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLogin();

        sleep(3000);
        mainPage.accountControl("Hesabım");
    }

    @Test
    public void loginUnSuccessful(){
        loginPage.fillEmail(email)
                .fillPassword("asd123")
                .clickLogin();
        sleep(3000);

        loginPage.errorMessageControl("E-posta adresiniz ve/veya şifreniz hatalı.")
                .fillEmail("asd@gmail.com")
                .clickLogin();
        sleep(3000);

        loginPage.errorMessageControl("E-posta adresiniz ve/veya şifreniz hatalı.");
    }

}
