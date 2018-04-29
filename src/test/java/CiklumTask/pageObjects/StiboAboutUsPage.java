package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StiboAboutUsPage extends PageObject {
    @FindBy(xpath = "//a[@class='icon-facebook']//child::img")
    public WebElement facebookIcon;
    @FindBy(xpath = "//a[contains(text(),'Blog')]")
    public WebElement blogLink;

    public StiboAboutUsPage(WebDriver driver) {
        super(driver);
    }
}
