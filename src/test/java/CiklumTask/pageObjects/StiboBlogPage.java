package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StiboBlogPage extends PageObject {
    @FindBy(name = "email")
    public WebElement emailField;
    @FindBy(css = "ul.hs-error-msgs.inputs-list li label")
    public WebElement wrongEmailMessage;
    @FindBy(className = "submitted-message")
    public WebElement correctEmailMessage;

    @FindBy(className = "icon-linkedin")
    public WebElement linkedinIcon;

    @FindBy(className = "filter-expand-link")
    public WebElement seeAllButton;
    @FindBy(linkText = "Customer Master Data Management (CMDM)")
    public WebElement cmdmCategoryButton;

    public StiboBlogPage(WebDriver driver) {
        super(driver);
    }
}
