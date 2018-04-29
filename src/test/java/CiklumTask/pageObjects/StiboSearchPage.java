package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StiboSearchPage extends PageObject {
    @FindBy(css = "div.search table tbody tr td img")
    public WebElement searchIcon;
    @FindBy(id = "search-input")
    public WebElement searchField;

    public StiboSearchPage(WebDriver driver) {
        super(driver);
    }
}
