package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    public By collection_button = By.xpath("//button[@class='btn btn-info FormalShoes']");

    public void clickCollectionButton() throws InterruptedException {
        clickOnElement(collection_button);
    }

    public boolean isCollectionButtonDisplayed() throws InterruptedException {
        return getDisplayStatus(collection_button);
    }

    public void scrollToProductPage() {
        scrollBy(500);
    }
}
