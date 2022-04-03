package BunningsPortal.pageObject;

import BunningsPortal.UIAutomationBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class HomePage extends UIAutomationBase {

    WebDriver driver;

    @FindBy(id = "custom-css-outlined-input")
    private WebElement searchTextBox;

    @FindBy(xpath = "//*[@id=\"header-search\"]/button")
    private WebElement searchButton;

    @FindBy(id = "crossIcon")
    private WebElement crossButton;

    @FindBy(xpath = "//*[@id=\"flyout\"]/div/div/div/div[1]/div/div[2]/div[1]/span")
    private WebElement spanSearch;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/main/div/div/div/div[1]/div[1]/p")
    private WebElement resultMessage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchTextBox() {
        return searchTextBox;
    }

    private void setSearchTextBox(String searchValue) {
        searchTextBox.sendKeys(searchValue);
    }

    public void searchItemFromAutoSuggestion() {
        setSearchTextBox(" ");
        String searchValue = spanSearch.getText();
        spanSearch.click();
        assertTrue(resultMessage.isDisplayed());
        assertEquals(searchValue, getSearchTextBox().getAttribute("value"));
        System.out.println("Searched 1st item from auto suggestion and successfully navigates to result page.");
        System.out.println("Test Passed");
    }

    public void SearchTextBoxVerifyMessageAndAssert() {
        String placeholder = searchTextBox.getAttribute("placeholder");
        assertEquals(placeholder, "Search products and more");
        System.out.println("Text box is visible and displays \"Search products and more\" as expected");
        System.out.println("Test Passed");
    }

    public void SearchTextBoxEnterInputAndAssert(String searchValue) {
        setSearchTextBox(searchValue);
        assertTrue(searchTextBox.isDisplayed());
        System.out.println("Search Text Box is displayed and able to enter value");
        System.out.println("Test Passed");
    }

    public void popularSearchesCloseTestAndAssert() {
        setSearchTextBox(" ");
        crossButton.click();
        assertFalse(crossButton.isSelected());
        System.out.println("Popular Searches has been closed successfully");
        System.out.println("Test Passed");
    }

}
