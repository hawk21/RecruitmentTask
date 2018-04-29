package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedinPage extends PageObject {
    @FindBy(xpath = "//input[@id = 'join-submit']")
    public WebElement joinNowButton;
    @FindBy(xpath = "//form[@id = 'join-form']")
    public WebElement joinForm;

    public LinkedinPage(WebDriver driver) {
        super(driver);
    }
}
