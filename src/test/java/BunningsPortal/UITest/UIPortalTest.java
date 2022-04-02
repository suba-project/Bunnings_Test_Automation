package BunningsPortal.UITest;

import BunningsPortal.UIAutomationBase;
import BunningsPortal.pageObject.HomePage;
import org.junit.jupiter.api.Test;

public class UIPortalTest extends UIAutomationBase {

    private HomePage homePageObject, homePage;
    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    //Verify search Text Box is displayed and able to enter text as expected.
    @Test
    public void searchTextBoxAnbAbleToEnterText(){
        homePageObject=getHomePage();
        homePageObject.SearchTextBoxEnterInputAndAssert("pen");
    }

    //Verify search message “Search products and more?” is displayed within the text box and upon clicking it disappears
    @Test
    public void searchTextBoxDisplayedAsExpectedTest(){
        homePageObject=getHomePage();
        homePageObject.SearchTextBoxVerifyMessageAndAssert();
    }

    //Verify search an item from auto-suggestion and click submit navigates to Results page
    @Test
    public void searchItemFromAutoSuggestionAndSubmit()  {
        homePageObject=getHomePage();
        homePageObject.searchItemFromAutoSuggestion();
    }

    //Verify search Message “What can we help you find today?" is displayed.
    @Test
    public void searchTextMessageIsDisplayed(){
        homePageObject=getHomePage();
        homePageObject.searchTextMessageDisappearsUponClicking();
    }

}