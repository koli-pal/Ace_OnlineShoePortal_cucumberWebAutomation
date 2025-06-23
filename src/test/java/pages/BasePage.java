package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSetup;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;



import static utilities.DriverSetup.getDriver;

public class BasePage  {

    public WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

    public WebElement getElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return getDriver().findElement(locator);
    }

    public List<WebElement> getAllElements(By locator)  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return getDriver().findElements(locator);
    }
    public  void clickOnElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    public void clearInputText(By locator)  {
        clickOnElement(locator);
        getElement(locator).clear();
    }
    public void writeOnElement(By locator, String text)  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public String getElementText(By locator)  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getElement(locator).getText();
    }

    public String getAttributeValue(By locator , String attributeName)  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getElement(locator).getDomAttribute(attributeName);
    }

    public String getPropertyValue(By locator, String propertyName)  {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return getElement(locator).getDomProperty(propertyName);
    }

    public String getElementCssValue(By locator, String propertyName) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getCssValue(propertyName);
    }

    public boolean getDisplayStatus(By locator)  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getElement(locator).isDisplayed();
    }

    public boolean getSelectedStatus(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getElement(locator).isSelected();
    }

    public boolean getEnableStatus(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getElement(locator).isEnabled();
    }

    public void loadAWebPage(String url){
        getDriver().get(url);
    }

    public void addScreenShoot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    public void hoverOnElement(By locator) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getElement(locator)).build().perform();
    }

    // navigate
    public void navigateBack(){
        getDriver().navigate().back();
    }
    public void navigateForward(){
        getDriver().navigate().forward();
    }
    public void refresh(){
        getDriver().navigate().refresh();
    }

    public void scrollIntoViewPoint(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)",getElement(locator));


    }

    public Dimension getDimension(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getElement(locator).getSize();
    }
    public int getButtonHeight(By locator) {
        Dimension dimension = getDimension(locator);
        return dimension.getHeight();
    }
    public int getButtonWidth(By locator) {
        Dimension dimension = getDimension(locator);
        return dimension.getWidth();
    }

    public boolean getElementInvisibilityStatus(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected WebDriver driver = DriverSetup.getDriver();
    public void scrollBy(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ");");
    }

    public String getPageTitle() {
        return DriverSetup.getDriver().getTitle();
    }

    public String getCurrentUrl() {
        return DriverSetup.getDriver().getCurrentUrl();
    }

}

