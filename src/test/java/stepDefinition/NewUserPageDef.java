package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.NewUserPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class NewUserPageDef extends BasePage {
    NewUserPage newUserPage ;

    @Given("the registration page is open")
    public void the_registration_page_is_open() {
        newUserPage = new NewUserPage();
       newUserPage.loadAWebPage("https://anupdamoda.github.io/AceOnlineShoePortal/Registration.html");
    }

    @Then("the registration page heading should be {string}")
    public void the_registration_page_heading_should_be(String expectedHeader) throws InterruptedException {
        String actualHeader = newUserPage.getRegistrationHeaderText();
        assertEquals(expectedHeader, actualHeader);
    }

    @When("first name {string} is entered")
    public void first_name_is_entered(String first) throws InterruptedException {
        newUserPage.enterFirstName(first);
    }

    @When("last name {string} is entered")
    public void last_name_is_entered(String last) throws InterruptedException {
        newUserPage.enterLastName(last);
    }

    @When("email {string} is entered")
    public void email_is_entered(String email) throws InterruptedException {
        newUserPage.enterEmail(email);
    }

    @When("contact number {string} is entered")
    public void contact_number_is_entered(String contact) throws InterruptedException {
        newUserPage.enterContactNumber(contact);
    }

    @When("New Username is entered {string}")
    public void NewUsername_is_entered(String user) throws InterruptedException {
        newUserPage.enterUserName(user);
    }

    @When("new user password is entered {string}")
    public void NewUserPassword_is_entered(String pass) throws InterruptedException {
        newUserPage.enterPassword(pass);
    }

    @Then("the submit button should be enabled")
    public void the_submit_button_should_be_enabled() throws InterruptedException {
        assertTrue(newUserPage.isSubmitButtonEnabled());
    }

    @When("the submit button is clicked")
    public void the_submit_button_is_clicked() throws InterruptedException {
        newUserPage.clickSubmitButton();
    }
}
