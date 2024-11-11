package testRunner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utilss.Utils;

import java.io.IOException;
import java.time.Duration;
import setup.SetUp;

public class SignUpTestRunner extends SetUp {
    SignUpPage signUpPage;
    @Test(priority = 1,description = "user can login with valid creds")
    public void userSignUp() throws IOException, ParseException, InterruptedException {
        signUpPage = new SignUpPage(SetUp.driver);
        Thread.sleep(3000);
        JSONArray userArray = Utils.readJSONData();
        JSONObject userObj = (JSONObject) userArray.get(userArray.size()-1);

        String email = userObj.get("email").toString();
        String password = userObj.get("password").toString();
        signUpPage.doSignUp(email,password);

        WebDriverWait wait = new WebDriverWait(SetUp.driver, Duration.ofSeconds(10));
        WebElement successRegElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Start your mock exam')]")));
        System.out.println(successRegElem.getText());
        String textTitle= successRegElem.getText();
        Assert.assertTrue(textTitle.contains("Start your mock exam"));


    }


    }

