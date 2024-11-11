package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserRegistration {
    @FindBy(className = "btn-close")
    public List<WebElement> addClick;

    @FindBy(className = "d-flex")
    public List<WebElement> menuBarRegBtn;

    @FindBy(className = "is-untouched")
    public List<WebElement> txtField;

    @FindBy(id = "phoneNumber")
    public List<WebElement> phoneNumber;

    @FindBy(id = "password")
    public List<WebElement> txtPassword;

    @FindBy(id = "confirmPassword")
    public List<WebElement> txtCnfrmPassword;

    @FindBy(css = "[type=submit]")
    public WebElement registerButton;

    public UserRegistration(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createNewUser(String fullname, String email, String phone, String password){
        txtField.get(0).sendKeys(fullname);
        txtField.get(1).sendKeys(email);
        phoneNumber.get(0).sendKeys(phone);
        txtPassword.get(0).sendKeys(password);
        txtCnfrmPassword.get(0).sendKeys(password);
        registerButton.click();
    }


}

