package pages;

import org.openqa.selenium.By;

public class NewUserPage extends BasePage {
    public By registration_header = By.xpath("//h1[normalize-space()='User Registration Page']");
    public By firstName = By.xpath("//input[@id='firstname']");
    public By lastName = By.xpath("//input[@id='lastname']");
    public By emailID = By.xpath("//input[@id='emailId']");
    public By contact_number = By.xpath("//input[@id='contactNumber']");
    public By userName = By.xpath("//input[@id='usr']");
    public By password = By.xpath("//input[@id='pwd']");
    public By submit_button = By.xpath("//input[@value='Submit']");

    public String getRegistrationHeaderText() throws InterruptedException {
        return getElementText(registration_header);
    }

    public void enterFirstName(String first) throws InterruptedException {
        writeOnElement(firstName, first);
    }

    public void enterLastName(String last) throws InterruptedException {
        writeOnElement(lastName, last);
    }

    public void enterEmail(String email) throws InterruptedException {
        writeOnElement(emailID, email);
    }

    public void enterContactNumber(String contact) throws InterruptedException {
        writeOnElement(contact_number, contact);
    }

    public void enterUserName(String user) throws InterruptedException {
        writeOnElement(userName, user);
    }

    public void enterPassword(String pass) throws InterruptedException {
        writeOnElement(password, pass);
    }

    public void clickSubmitButton() throws InterruptedException {
        clickOnElement(submit_button);
    }

    public boolean isSubmitButtonEnabled() throws InterruptedException {
        return getEnableStatus(submit_button);
    }

}