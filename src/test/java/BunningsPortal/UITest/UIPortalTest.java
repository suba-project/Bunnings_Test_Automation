package BunningsPortal.UITest;

import BunningsPortal.UIAutomationBase;
import BunningsPortal.pageObject.HomePage;
import org.junit.jupiter.api.Test;

public class UIPortalTest extends UIAutomationBase {

    private HomePage homePageObject, homePage;
    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    // TC001: Verify search Text Box is displayed and able to enter text as expected.
    @Test
    public void searchTextBoxAnbAbleToEnterText(){
        homePageObject=getHomePage();
        homePageObject.SearchTextBoxEnterInputAndAssert("pen");
    }

    //TC002: Verify search message “Search products and more?” is displayed within the text box and
    // upon clicking it disappears
    @Test
    public void searchTextBoxDisplayedAsExpectedTest(){
        homePageObject=getHomePage();
        homePageObject.SearchTextBoxVerifyMessageAndAssert();
    }

    //TC003: Verify search an item from auto-suggestion and click submit navigates to Results page
    @Test
    public void searchItemFromAutoSuggestionAndSubmit()  {
        homePageObject=getHomePage();
        homePageObject.searchItemFromAutoSuggestion();
    }

    //TC020: Verify “Popular searches” can be closed using the cross X button on the suggestion list
    @Test
    public void popularSearchesCloseTestAndAssert(){
        homePageObject=getHomePage();
        homePageObject.popularSearchesCloseTestAndAssert();
    }

}