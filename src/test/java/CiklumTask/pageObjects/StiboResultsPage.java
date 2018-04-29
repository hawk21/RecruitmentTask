package CiklumTask.pageObjects;

import CiklumTask.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StiboResultsPage extends PageObject {
    @FindBy(xpath = "//div[@class='ais-body ais-stats--body']")
    private WebElement resultsCount;
    @FindBy(xpath = "//span[@class='ais-stats--time']")
    private WebElement statsTime;
    @FindBy(xpath = "//div[@class='ais-hits--item']//child::a")
    private List<WebElement> elementsOnStiboResults;
    @FindBy(xpath = "//li[contains(@class, 'active')]//child::a")
    private WebElement currentPageNumber;
    @FindBy(xpath = "//li[contains(@class, 'next')]//child::a")
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
