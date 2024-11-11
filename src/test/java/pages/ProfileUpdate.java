package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import setup.SetUp;

public class ProfileUpdate extends SetUp {

    @FindBy(tagName = "b")
    public WebElement clickBtn;

    @FindBy(id = "radio-gender-female")
    WebElement radioBtn;

    @FindBy(id="dob")
    public WebElement txtDob;

    @FindBy(id = "education")
    WebElement txtEdu;

    @FindBy(css = "[role=combobox]")
    WebElement unidrpdwn;

    @FindBy(className = "profile-submit-page-btn")
    WebElement submitBtn;

    public ProfileUpdate(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
     Actions actions;
    public void userProfileUpdate(){
      txtDob.sendKeys("10051999");
      ((JavascriptExecutor) SetUp.driver).executeScript("window.scrollBy(0, 200);");
      radioBtn.click();
      Select dropdown = new Select(txtEdu);
      dropdown.selectByVisibleText("BSC");
      actions = new Actions(SetUp.driver);
        WebDriverWait wait = new WebDriverWait(SetUp.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(unidrpdwn)).click();
        actions.sendKeys("University of Dhaka")
                .sendKeys(Keys.ENTER)
                .perform();
      submitBtn.click();

    }



}
