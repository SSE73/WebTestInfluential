package influential.signUp;

import influential.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class SignUp extends WebDriverSettings {


    @Test
    public void singUp() {

        HomePage homePage = PageFactory.initElements(driver,HomePage.class);

        homePage.open();

        homePage.getStarted();

        SignUpPage signUpPage = PageFactory.initElements(driver,SignUpPage.class);

        signUpPage.openSignUpForm();

        signUpPage.fillFirstName("Sergey");

        signUpPage.fillLastName("Sysylyatin");

        Random random = new Random();

        int n = random.nextInt(100) +1;

        String email = "Sysylyatin" + n + "@mail.ru";
        String username = "Sysylyatin" + n;

        System.out.println(email);
        System.out.println(username);

        signUpPage.fillEmail(email);

        signUpPage.fillCompanyName("It");

        signUpPage.fillUserName(username);

        signUpPage.fillPassword("123456789");

        signUpPage.fillConfirmPassword("123456789");

        signUpPage.submitForm();

        signUpPage.checkSignUpSuccess();
    }

    @Test
    public void singUpFailure() {

        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.open();
        homePage.getStarted();

        SignUpPage signUpPage = PageFactory.initElements(driver,SignUpPage.class);
        signUpPage.openSignUpForm();
        signUpPage.submitForm();

        signUpPage.checkErrorReguredFields();

        Assert.assertEquals(signUpPage.getFirstNameError(),"PLEASE ADD A FIRST NAME");

        Assert.assertEquals(signUpPage.getNameLastError(),"PLEASE ADD A LAST NAME");

        Assert.assertEquals(signUpPage.getEmailError(),"PLEASE ADD AN EMAIL ADDRESS");


        Assert.assertEquals(signUpPage.getCompanyNameError(), "PLEASE ADD A COMPANY NAME");

        Assert.assertEquals(signUpPage.getUserNameError(), "PLEASE ADD A USERNAME");

        Assert.assertEquals(signUpPage.getPasswordError(),"PLEASE ADD A PASSWORD");

        Assert.assertEquals(signUpPage.getConfirmPasswordError(),"PLEASE CONFIRM YOUR PASSWORD");

    }

}
