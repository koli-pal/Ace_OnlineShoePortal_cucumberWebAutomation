package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.ProductPage2;

import static org.testng.AssertJUnit.*;

public class ProductPage2Def extends BasePage {
    ProductPage2 productPage2 ;

    @Given("the product details page is opened")
    public void the_product_details_page_is_opened() {
        productPage2 = new ProductPage2();
        productPage2.loadAWebPage("https://anupdamoda.github.io/AceOnlineShoePortal/FormalShoeslist.html");
    }

    @Then("there should be visible product name")
    public void the_product_name_of_page2_should_be_visible() throws InterruptedException {
        assertNotNull(productPage2.getProductName());
    }

    @Then("the product image should be displayed")
    public void the_product_image_should_be_displayed() throws InterruptedException {
        assertTrue(productPage2.isProductImageVisible());
    }

    @When("selecting the color {string}")
    public void selecting_the_color(String color) throws InterruptedException {
        productPage2.selectProductColor(color);
    }

    @When("selecting the size {string}")
    public void selecting_the_size(String size) throws InterruptedException {
        productPage2.selectProductSize(size);
    }

    @Then("the product price should be {string}")
    public void the_product_price_should_be(String expectedPrice) throws InterruptedException {
        String actualPrice = productPage2.getProductPrice();
        assertEquals(expectedPrice, actualPrice);
    }

    @When("the {string} button is clicked")
    public void the_button_is_clicked(String buttonName) throws InterruptedException {
        if (buttonName.equalsIgnoreCase("Add to Cart")) {
            productPage2.clickAddToCart();
        }
    }
}
