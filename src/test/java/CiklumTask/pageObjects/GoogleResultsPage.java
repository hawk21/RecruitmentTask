package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleResultsPage extends PageObject {
    @FindBy(xpath = "//h3[@class='r']/child::a")
    private List<WebElement> elementsOnResultsPage;

    public GoogleResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement lookForWebsite(String website) throws Exception {
        return elementsOnResultsPage.stream()
                .filter(webElement -> webElement.getAttribute("href").contains(website))
                .findFirst()
                .orElseThrow(() -> new Exception(website + " has not been found."));
    }
}
