package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.ProductPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ProductPageDef extends BasePage {
    ProductPage productPage ;

    @Given("the product page is opened")
    public void the_product_page_is_opened() {
        productPage = new ProductPage();
       productPage.loadAWebPage("https://anupdamoda.github.io/AceOnlineShoePortal/ShoeTypes.html");
    }

    @Then("the collection button should be displayed")
    public void the_collection_button_should_be_displayed() throws InterruptedException {
        assertTrue(productPage.isCollectionButtonDisplayed());
    }

    @When("the collection button is clicked")
    public void the_collection_button_is_clicked() throws InterruptedException {
        productPage.clickCollectionButton();
    }

}

