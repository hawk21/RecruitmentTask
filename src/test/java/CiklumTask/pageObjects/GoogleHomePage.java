package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends PageObject {
    @FindBy(xpath = "//input[@name='q']")
    public WebElement SearchField;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }
}
