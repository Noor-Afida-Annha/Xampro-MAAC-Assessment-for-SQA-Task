package testRunner;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserRegistration;
import utilss.Utils;

import java.io.IOException;
import java.time.Duration;
import setup.SetUp;



public class UserTestRunner extends SetUp {
    UserRegistration userRegistration;

    @Test(priority = 1, description = "user can register with valid creds")
    public  void createUser() throws IOException, ParseException {
        userRegistration = new UserRegistration(SetUp.driver);
        userRegistration.addClick.get(1).click();
        userRegistration.menuBarRegBtn.get(1).click();
        String fullname = "testUser";
        String email = "65q48@livinitlarge.net";
        String phone = "01502"+ Utils.generateRandomId(100000,999999);
        String password = "P@ssword1234";

        userRegistration.createNewUser(fullname, email, phone, password);
        WebDriverWait wait = new WebDriverWait(SetUp.driver, Duration.ofSeconds(10));
        WebElement successRegElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Check your email')]")));
        System.out.println(successRegElem.getText());
        String textTitle= successRegElem.getText();
        Assert.assertTrue(textTitle.contains("Check your email"));



        Utils.saveUsers(fullname,email,phone,password);

    }






}

