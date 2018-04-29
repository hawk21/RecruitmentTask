package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StiboAboutUsPage extends PageObject {
    @FindBy(css = "a.icon-facebook img")
    public WebElement facebookIcon;
    @FindBy(linkText = "Blog")
    public WebElement blogLink;

    public StiboAboutUsPage(WebDriver driver) {
        super(driver);
    }
}
