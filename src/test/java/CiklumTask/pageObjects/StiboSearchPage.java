package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StiboSearchPage extends PageObject {
    @FindBy(xpath = "//div[@class='search']//child::img")
    public WebElement searchIcon;
    @FindBy(xpath = "//input[@id='search-input']")
    public WebElement searchField;

    public StiboSearchPage(WebDriver driver) {
        super(driver);
    }
}
