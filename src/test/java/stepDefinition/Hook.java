package stepDefinition;

import io.cucumber.java.*;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.DriverSetup;

public class Hook {

    public static SoftAssert softAssert;

    @Before
    public void beforeScenario() {
        String browserName = System.getProperty("browser", "Chrome");
        DriverSetup.openABrowser(browserName);
        softAssert = new SoftAssert();
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = takeScreenshot(DriverSetup.getDriver());
                scenario.attach(screenshot, "image/png", "Failure Screenshot"); // For Cucumber report
                attachToAllure(screenshot); // For Allure report
            }

            softAssert.assertAll();
        } catch (AssertionError e) {
            System.out.println("Soft assertion failure: " + e.getMessage());
            Assert.fail(e.getMessage());
        } finally {
            DriverSetup.closeBrowser();
        }
    }

    public byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public static byte[] attachToAllure(byte[] screenshot) {
        return screenshot;
    }
}

