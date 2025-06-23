package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertTrue;
import static stepDefinition.Hook.softAssert;

public class LoginPageDef extends BasePage {
    LoginPage loginPage ;

    @Given("the login page is open")
    public void the_login_page_is_open() {
        loginPage = new LoginPage();
        if (softAssert == null) softAssert = new SoftAssert();
        loginPage.loadAWebPage("https://anupdamoda.github.io/AceOnlineShoePortal/SignIn.html");
        softAssert.assertTrue(loginPage.getPageTitle().contains("Ace Online Shoe Portal"),
                "Login page title does not contain expected text 'Ace Online Shoe Portal'");
    }

    @Then("Username field should present")
    public void usernameFieldShouldPresent() throws InterruptedException {
        if (softAssert == null) softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.getDisplayStatus(loginPage.userName),
                "Username field is not visible on the login page.");
    }
    @And("Username field should be writable")
    public void usernameFieldShouldBeWritable() throws InterruptedException {
        if (softAssert == null) softAssert = new SoftAssert();

        boolean enableStatus = loginPage.getEnableStatus(loginPage.userName);
        softAssert.assertTrue(enableStatus,"Username field is not enabled");

        String readOnly = loginPage.getPropertyValue(loginPage.userName,"readOnly");
        softAssert.assertEquals(readOnly,"false", "Username field is read only");
    }
    @And("Password field should be present")
    public void passwordFieldShouldPresent() throws InterruptedException {
        if (softAssert == null) softAssert = new SoftAssert();

        softAssert.assertTrue(loginPage.getDisplayStatus(loginPage.passWord),
                "Password field is not displayed");
    }

    @And("Password field should be writable")
    public void passwordFieldShouldBeWritable() throws InterruptedException {
        if (softAssert == null) softAssert = new SoftAssert();

        boolean enableStatus = loginPage.getEnableStatus(loginPage.passWord);
        softAssert.assertTrue(enableStatus,"password field is not enabled");

        String readOnly = loginPage.getPropertyValue(loginPage.passWord,"readOnly");
        softAssert.assertEquals(readOnly,"false", "password field is read only");
    }
    @And("Login button should present")
    public void loginButtonShouldPresent() throws InterruptedException {
        if (softAssert == null) softAssert = new SoftAssert();

        softAssert.assertTrue(loginPage.getDisplayStatus(loginPage.login_button),
                "Login button is not displayed");
    }
    @Then("Login button label should be {string}")
    public void loginButtonLabelShouldBe(String expectedLabel) {
        if (softAssert == null) softAssert = new SoftAssert();

        String actualLabel = loginPage.getPropertyValue(loginPage.login_button, "value");
        softAssert.assertEquals(actualLabel, expectedLabel,
                "Login button label doesn't match. Expected: " + expectedLabel + ", but got: " + actualLabel);
    }

    @And("the login button should be enabled")
    public void the_login_button_should_be_enabled()throws InterruptedException {
        assertTrue("Login button is not enabled.", loginPage.isLoginButtonEnabled());
    }

    @Then("the new user button should be visible")
    public void the_new_user_button_should_be_visible()throws InterruptedException {
        assertTrue("New User button is not visible on the login page.", loginPage.isNewUserButtonVisible());
    }

    @When("username {string} is entered")
    public void username_is_entered(String username)throws InterruptedException {
        if (softAssert == null) softAssert = new SoftAssert();

        loginPage.enterUsername(username);
        String actualValue = loginPage.getInputValue(loginPage.userName);
        softAssert.assertEquals(actualValue, username, "Entered username does not match input value.");
    }

    @When("password {string} is entered")
    public void password_is_entered(String password)throws InterruptedException {
        if (softAssert == null) softAssert = new SoftAssert();

        loginPage.enterPassword(password);
        String actualValue = loginPage.getInputValue(loginPage.passWord);
        softAssert.assertEquals(actualValue, password, "Entered password does not match input value.");
    }

    @When("the login button is clicked")
    public void the_login_button_is_clicked()throws InterruptedException {
        if (softAssert == null) softAssert = new SoftAssert();

        loginPage.clickLoginButton();
        softAssert.assertTrue(true, "Login button click action failed.");
    }

}
