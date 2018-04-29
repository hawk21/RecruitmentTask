package CiklumTask;

import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FunctionalTesting {
    protected static WebDriver driver;
    private static WebDriverWait driverWait;
    private static final String BASE_URL = "http://www.google.com";

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    protected static WebElement waitForVisibility(WebElement webElement) {
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    protected static WebElement waitForClickable(WebElement webElement) {
        driverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
