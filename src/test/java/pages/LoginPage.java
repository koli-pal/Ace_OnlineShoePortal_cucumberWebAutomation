package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.DriverSetup;


public class LoginPage extends BasePage {
    public By userName = By.xpath("//input[@id='usr']");
    public  By passWord = By.xpath("//input[@id='pwd']");
    public  By login_button = By.xpath("//input[@value='Login']");
    public  By newUser_button = By.xpath("//button[@id='NewRegistration']");

    public void enterUsername(String username) throws InterruptedException {
        writeOnElement(userName, username);
    }

    public void enterPassword(String password) throws InterruptedException {
        writeOnElement(passWord, password);
    }

    public void clickLoginButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(login_button));
        clickOnElement(login_button);
    }

    public void clickNewUserButton() throws InterruptedException {
        clickOnElement(newUser_button);
    }

    public boolean isLoginButtonEnabled() throws InterruptedException {
        return getEnableStatus(login_button);
    }

    public boolean isNewUserButtonVisible() throws InterruptedException {
        return getDisplayStatus(newUser_button);
    }

    public void assertLoginButtonEnabled() {
        if (!getEnableStatus(login_button)) {
            throw new AssertionError("Login button is not enabled.");
        }
    }

    public void scrollToLogin() {
        scrollBy(500);
    }

    public String getInputValue(By locator) {
        return DriverSetup.getDriver().findElement(locator).getAttribute("value");
    }


}
