package com.amazon.step_definitions;

import com.amazon.pages.AmazonPage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AmazonStepDefination {

    AmazonPage amazonPage = new AmazonPage();

    @When("User go to amazon page")
    public void userGoToAmazonPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @Then("User on the home page")
    public void userOnTheHomePage() {
        Assert.assertTrue(amazonPage.amazonLogo.isDisplayed());
    }

    @And("Accept cookies")
    public void acceptCookies() {
        amazonPage.cookies.click();

    }

    @Then("Login the amazon page")
    public void loginTheAmazonPage() {
        amazonPage.toLoginPage.click();
        amazonPage.emailBox.sendKeys(ConfigurationReader.getProperty("email")+ Keys.ENTER);

        amazonPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password")+Keys.ENTER);
    }

    @And("User logged on the amazon")
    public void userLoggedOnTheAmazon() {
        Assert.assertFalse(amazonPage.accountList.getText().equals("Merhaba, Giriş yapın"));

    }

    @Then("user select {string} category")
    public void userSelectCategory(String arg0) {
        Select select = new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));

        select.selectByVisibleText(arg0);

    }

    @And("{string} category selected")
    public void categorySelected(String arg0) {
        Select select = new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));

        Assert.assertTrue(select.getFirstSelectedOption().getText().equals(arg0));

    }

    @Then("user type {string} and search")
    public void userTypeAndSearch(String arg0) {
        amazonPage.searchBox.sendKeys(arg0+Keys.ENTER);
    }

    @And("user see search result")
    public void userSeeSearchResult() {
        Assert.assertTrue(amazonPage.result.isDisplayed());
    }

    @Then("user go to second page")
    public void userGoToSecondPage() {
        BrowserUtils.scrollToElement(amazonPage.secondPage);
        amazonPage.secondPage.click();
    }

    @And("user see second page result")
    public void userSeeSecondPageResult() {
        BrowserUtils.scrollToElement(amazonPage.secondProduct);
        amazonPage.secondProduct.click();
    }

    @Then("user add the second product to favorite")
    public void userAddTheSecondProductToFavorite() {
        BrowserUtils.scrollToElement(amazonPage.addToList);
        amazonPage.addToList.click();
    }

    @And("user see product added to favorite")
    public void userSeeProductAddedToFavorite() {

        Assert.assertEquals("1 ürün şuraya eklendi:", amazonPage.addedMessage.getText());

    }

    @Then("user go to the list of favorite")
    public void userGoToTheListOfFavorite() throws InterruptedException {
        BrowserUtils.hover(amazonPage.closeButton);
        amazonPage.closeButton.click();

        BrowserUtils.scrollToElement(amazonPage.accountList);
        Thread.sleep(2000);
        BrowserUtils.hover(amazonPage.accountList);
        Thread.sleep(2000);
        amazonPage.favoriteListButton.click();

    }

    @And("user see list of favorite")
    public void userSeeListOfFavorite() {
        Assert.assertTrue(amazonPage.favoriteList.isDisplayed());
    }

    @Then("user deletes the product in the favorite list")
    public void userDeletesTheProductInTheFavoriteList() {
        amazonPage.deleteButton.click();
    }

    @And("user sees product is deleted")
    public void userSeesProductIsDeleted() {
        Assert.assertTrue(amazonPage.deleteMessage.isDisplayed());
    }

    @Then("user logout")
    public void userLogout() throws InterruptedException {

        BrowserUtils.hover(amazonPage.accountList);
        Thread.sleep(2000);
        amazonPage.logoutButton.click();
    }

    @And("user can logout")
    public void userCanLogout() {

        WebElement loginPage = Driver.getDriver().findElement(By.xpath("//di[@class='a-box-inner a-padding-extra-large']"));
        Assert.assertTrue(loginPage.isDisplayed());
    }



}
