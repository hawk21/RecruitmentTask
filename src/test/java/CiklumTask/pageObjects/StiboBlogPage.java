package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StiboBlogPage extends PageObject {
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;
    @FindBy(xpath = "//label[contains(text(), 'Email must be')]")
    public WebElement wrongEmailMessage;
    @FindBy(xpath = "//div[@class = 'submitted-message']")
    public WebElement correctEmailMessage;

    @FindBy(xpath = "//a[@class='icon-linkedin']")
    public WebElement linkedinIcon;

    @FindBy(xpath = "//a[contains(text(), 'See All')]")
    public WebElement seeAllButton;
    @FindBy(xpath = "//div[@class='widget-module']//child::a[contains(text(), 'CMDM')]")
    public WebElement cmdmCategoryButton;

    public StiboBlogPage(WebDriver driver) {
        super(driver);
    }
}
