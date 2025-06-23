package pages;

import org.openqa.selenium.By;

public class ProductPage2 extends BasePage {
    public By productName = By.xpath("//tbody/tr[1]/td[1]");
    public By productImage = By.xpath("//img[@src='assets/images/FormalShoes/ClassicCheltenham.jpg']");
    public By productColorBlack = By.xpath("//body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/select[1]");
    public By productSize = By.xpath("//body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/select[1]");
    public By productPrice = By.xpath("//td[normalize-space()='$155']");
    public By addToCart_button = By.xpath("//body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[6]/button[1]");

    public String getProductName() throws InterruptedException {
        return getElementText(productName);
    }

    public boolean isProductImageVisible() throws InterruptedException {
        return getDisplayStatus(productImage);
    }

    public void selectProductColor(String color) throws InterruptedException {
        getElement(productColorBlack).sendKeys("Black");
    }

    public void selectProductSize(String size) throws InterruptedException {
        getElement(productSize).sendKeys("7");
    }

    public String getProductPrice() throws InterruptedException {
        return getElementText(productPrice);
    }

    public void clickAddToCart() throws InterruptedException {
        clickOnElement(addToCart_button);
    }

}
