package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StiboResultsPage extends PageObject {
    @FindBy(css = "div.ais-body.ais-stats--body")
    private WebElement resultsCount;
    @FindBy(css = "span.ais-stats--time")
    private WebElement statsTime;
    @FindBy(css = "div.ais-hits div.ais-hits--item a")
    private List<WebElement> elementsOnStiboResults;
    @FindBy(css = "#pagination > div > ul > li.ais-pagination--item.ais-pagination--item__page.ais-pagination--item__active")
    private WebElement currentPageNumber;
    @FindBy(linkText = "›")
    private WebElement nextPageButton;

    public StiboResultsPage(WebDriver driver) {
        super(driver);
    }

    public void printResultsCount() {
        String resultsCountText = resultsCount.getText();
        String statsTimeText = statsTime.getText();

        String requiredText = resultsCountText.replace(statsTimeText, "");
        System.out.println(requiredText);
    }

    public void lookFor(String searchQuery, int pageLimit) throws Exception {
        Thread.sleep(1000 * 3);

        if (pageLimit > 0) {
            for (WebElement element : elementsOnStiboResults) {
                if (element.getText().equals(searchQuery)) {
                    String pageNumber = currentPageNumber.getText();
                    System.out.println(searchQuery + " found on page no.: " + pageNumber);

                    element.click();
                    return;
                }
            }
            nextPageButton.click();
            lookFor(searchQuery, pageLimit - 1);
        } else {
            throw new Exception(searchQuery + " page has not been found.");
        }
    }
}
