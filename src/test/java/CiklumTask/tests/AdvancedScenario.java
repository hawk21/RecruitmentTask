package CiklumTask.tests;

import CiklumTask.FunctionalTesting;
import CiklumTask.pageObjects.GoogleHomePage;
import CiklumTask.pageObjects.GoogleResultsPage;
import CiklumTask.pageObjects.LinkedinPage;
import CiklumTask.pageObjects.StiboAboutUsPage;
import CiklumTask.pageObjects.StiboBlogPage;
import CiklumTask.pageObjects.StiboResultsPage;
import CiklumTask.pageObjects.StiboSearchPage;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvancedScenario extends FunctionalTesting {
    private static final String GOOGLE_SEARCH_QUERY = "stibo systems";
    private static final String STIBO_SEARCH_QUERY = "energy";
    private static final String STIBO_WEBSITE = "www.stibosystems.com";
    private static final String RESULTS_SEARCH_QUERY = "About Us";
    private static final String CORRECT_EMAIL = "hawk.21@gmail.com";
    private static final String INCORRECT_EMAIL = "test";
    private static final String THANKS_MESSAGE = "Thanks for Subscribing!";
    private static final int PAGE_LIMIT = 20;

    private GoogleHomePage googleHomePage = new GoogleHomePage(driver);
    private GoogleResultsPage googleResultsPage = new GoogleResultsPage(driver);
    private StiboSearchPage stiboPage = new StiboSearchPage(driver);
    private StiboAboutUsPage stiboAboutUsPage = new StiboAboutUsPage(driver);
    private StiboResultsPage stiboResultsPage = new StiboResultsPage(driver);
    private StiboBlogPage stiboBlogPage = new StiboBlogPage(driver);
    private LinkedinPage linkedinPage = new LinkedinPage(driver);

    @Test
    public void advancedScenario() throws Exception {
        //2
        googleHomePage.SearchField.sendKeys(GOOGLE_SEARCH_QUERY);
        googleHomePage.SearchField.submit();

        //3
        googleResultsPage.lookForWebsite(STIBO_WEBSITE).click();

        //4
        waitForClickable(stiboPage.searchIcon);
        stiboPage.searchIcon.click();
        stiboPage.searchField.sendKeys(STIBO_SEARCH_QUERY);

        //5
        Thread.sleep(1000 * 3);
        stiboResultsPage.printResultsCount();

        //6
        stiboResultsPage.lookFor(RESULTS_SEARCH_QUERY, PAGE_LIMIT);

        //7
        assertThat(stiboAboutUsPage.facebookIcon.isDisplayed()).isTrue();

        //8
        stiboAboutUsPage.blogLink.click();

        //9
        stiboBlogPage.emailField.sendKeys(INCORRECT_EMAIL);
        stiboBlogPage.emailField.submit();

        System.out.println(stiboBlogPage.wrongEmailMessage.getText());

        //10
        stiboBlogPage.emailField.clear();
        stiboBlogPage.emailField.sendKeys(CORRECT_EMAIL);
        stiboBlogPage.emailField.submit();

        //11
        waitForVisibility(stiboBlogPage.correctEmailMessage);
        assertThat(stiboBlogPage.correctEmailMessage.getText().equals(THANKS_MESSAGE));

        //12
        stiboBlogPage.linkedinIcon.click();

        //13
        ArrayList<String> browserTabsArray = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabsArray.get(1));
        waitForVisibility(linkedinPage.joinNowButton);
        linkedinPage.joinNowButton.submit();

        //14
        waitForVisibility(linkedinPage.joinForm);
        assertThat(linkedinPage.joinForm.isDisplayed());

        //15
        driver.close();
        driver.switchTo().window(browserTabsArray.get(0));

        //16
        stiboBlogPage.seeAllButton.click();
        stiboBlogPage.cmdmCategoryButton.click();
    }
}
