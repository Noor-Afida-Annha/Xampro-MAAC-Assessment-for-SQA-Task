package testRunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ProfileUpdate;
import pages.SignUpPage;
import setup.SetUp;


public class ProfileUpdateTestRunner extends SetUp {

    ProfileUpdate profileUpdate;

    @BeforeTest
    public void doLogin() throws InterruptedException {
        Thread.sleep(1000);
        SignUpPage signUpPage = new SignUpPage(SetUp.driver);
        signUpPage.doSignUp("65q48@livinitlarge.net","P@ssword1234");
    }
    
    @Test(priority = 1, description = "user can update their profile")
    public void profileUpdate() throws InterruptedException {
        profileUpdate =new ProfileUpdate(SetUp.driver);
        profileUpdate.clickBtn.click();
        profileUpdate.userProfileUpdate();

    }
}
