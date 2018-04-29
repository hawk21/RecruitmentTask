package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedinPage extends PageObject {
    @FindBy(css = "input#join-submit.join.submit-button")
    public WebElement joinNowButton;
    @FindBy(css = "form#join-form.join-form")
    public WebElement joinForm;

    public LinkedinPage(WebDriver driver) {
        super(driver);
    }
}
