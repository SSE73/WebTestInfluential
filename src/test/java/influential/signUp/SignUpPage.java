package influential.signUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver,10);

    }

    @FindBy(css = "[href=\"/signup/talent#form-anchor\"]")
    private WebElement formAnchor;

    private By formLocator = By.cssSelector("form");

    @FindBy(id = "name-first")
    private WebElement nameFirst;

    @FindBy(id = "name-last")
    private WebElement nameLast;

    @FindBy(id ="email")
    private WebElement email;

    @FindBy(id = "company-name")
    private WebElement companyName;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password-confirm")
    private WebElement passwordConfirm;

    @FindBy(css = "button[type=\"submit\"]" )
    private WebElement submit;

    private By signupComplete = By.id("signup-complete");

    private By errorMsg = By.cssSelector("[class=\"error error-msg\"]");


    public void openSignUpForm() {

        formAnchor.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));

    }

    public void fillFirstName(String firstName) {

        nameFirst.sendKeys(firstName);

    }

    public void fillLastName(String lastName) {

        nameLast.sendKeys(lastName);

    }

    public void fillEmail(String emailText) {

        email.sendKeys(emailText);

    }

    public void fillCompanyName(String company) {

        companyName.sendKeys(company);

    }

    public void fillUserName(String usernameText) {

        username.sendKeys(usernameText);
    }

    public void fillPassword(String pass) {

        password.sendKeys(pass);

    }

    public void fillConfirmPassword(String pass) {

        passwordConfirm.sendKeys(pass);

    }

    public void submitForm() {

        submit.click();

    }

    public void checkSignUpSuccess() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(signupComplete));

    }

    public void checkErrorReguredFields() {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMsg));

    }

    public String getFirstNameError() {

        WebElement nameFirstParent =  nameFirst.findElement(By.xpath(".."));
        return nameFirstParent.findElement(By.cssSelector("p")).getText();

    }

    public String getNameLastError() {
        WebElement nameLastParent = nameLast.findElement(By.xpath(".."));
        return nameLastParent.findElement(By.cssSelector("p")).getText();

    }

    public String getEmailError() {

        WebElement emailParent = email.findElement(By.xpath(".."));
        return emailParent.findElement(By.cssSelector("p")).getText();
    }

    public String getCompanyNameError() {

        WebElement companyNameParent = companyName.findElement(By.xpath(".."));
        return companyNameParent.findElement(By.cssSelector("p")).getText();

    }

    public String getUserNameError() {

        WebElement usernameParent = username.findElement(By.xpath(".."));
        return usernameParent.findElement(By.cssSelector("p")).getText();

    }

    public String getPasswordError() {

        WebElement passwordParent = password.findElement(By.xpath(".."));
        return passwordParent.findElement(By.cssSelector("p")).getText();

    }

    public String getConfirmPasswordError() {

        WebElement passwordConfirmParent = passwordConfirm.findElement(By.xpath(".."));
        return passwordConfirmParent.findElement(By.cssSelector("p")).getText();

    }
}
