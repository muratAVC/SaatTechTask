package avci.murat.step_definitions;

import avci.murat.pages.Ultra_Task_Page;
import avci.murat.utilities.BrowserTools;
import avci.murat.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UltraStepDef {
    Ultra_Task_Page ultraTaskPage=new Ultra_Task_Page();

    @Given("user add to {string}")
    public void user_add_to(String string) {
        ultraTaskPage.userinput.sendKeys(string);
    }
    @Given("user click to login button")
    public void user_click_to_login_button() {
        ultraTaskPage.logButton.click();
    }
    @Given("user can see main page")
    public void user_can_see_main_page() {
        try {
            Assert.assertTrue(ultraTaskPage.mainPageTitle.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(ultraTaskPage.errorMessage.isDisplayed());
        }
    }

    @And("user add password {string}")
    public void userAddPassword(String pass) {
        ultraTaskPage.passinput.sendKeys(pass);
    }

    @Given("User open page")
    public void userOpenPage() {
        Driver.getWebDriver().navigate().to("https://www.saucedemo.com/");
    }

    @And("user can see sort button")
    public void userCanSeeSortButton() {
        Assert.assertTrue(ultraTaskPage.sortSelect.isDisplayed());
    }


    @And("user click to sort button {string}")
    public void userClickToSortButton(String arg0) {
        Actions actions=new Actions(Driver.getWebDriver());
       actions.click(ultraTaskPage.sortSelect).perform();
        for (int i = 0; i <3 ; i++) {
            actions.sendKeys(Keys.UP).perform();
        }
        switch (arg0) {
            case "Name (A to Z)":
                actions.sendKeys(Keys.ENTER).perform();
                BrowserTools.waitFor(3);
                break;
            case "Name (Z to A)":
                actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
                BrowserTools.waitFor(3);
                break;
            case "Price (low to high)":
                actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
                BrowserTools.waitFor(3);
                break;
            case "Price (high to low)":
                actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
                BrowserTools.waitFor(3);
                break;
        }

    }

    @And("user can see sort result {string}")
    public void userCanSeeSortResult(String arg0) {
        List<String> itemTitleList_Orj=new ArrayList<>();
        List<String> itemTitleList_Sorted=new ArrayList<>();
        for (WebElement elem:ultraTaskPage.itemTitle) {
            itemTitleList_Orj.add(elem.getText());
            itemTitleList_Sorted.add(elem.getText());
        }

        List<Double> itemPrice=new ArrayList<>();
        List<Double> itemPrice_Sorted =new ArrayList<>();
        for (WebElement elem: ultraTaskPage.itemPrice) {
            itemPrice.add(Double.valueOf(elem.getText().substring(1)));
            itemPrice_Sorted.add(Double.valueOf(elem.getText().substring(1)));
        }

        switch (arg0) {
            case "Name (A to Z)":
                Collections.sort(itemTitleList_Sorted);
                System.out.println("A-Z"+itemTitleList_Sorted);
                Assert.assertTrue(itemTitleList_Orj.equals(itemTitleList_Sorted));
                break;
            case "Name (Z to A)":
                Collections.sort(itemTitleList_Sorted);
                Collections.reverse(itemTitleList_Sorted);
                System.out.println("Z-A"+itemTitleList_Sorted);
                Assert.assertTrue(itemTitleList_Orj.equals(itemTitleList_Sorted));
                break;
            case "Price (low to high)":
                Collections.sort(itemPrice_Sorted);
                System.out.println("artan fiyat"+itemPrice_Sorted);
                Assert.assertTrue(itemPrice.equals(itemPrice_Sorted));

                break;
            case "Price (high to low)":
                Collections.sort(itemTitleList_Sorted);
                Collections.reverse(itemTitleList_Sorted);
                System.out.println("azalan fiyat"+itemPrice_Sorted);
                Assert.assertTrue(itemPrice.equals(itemPrice_Sorted));
                break;



        }
    }

    @Given("user click to left menu button")
    public void user_click_to_left_menu_button() {
        ultraTaskPage.leftMenuButton.click();
    }
    @Given("user click to reset button")
    public void user_click_to_reset_button() {
       ultraTaskPage.resetButton.click();
    }
    @Given("user can see add to cart button")
    public void user_can_see_add_to_cart_button() {
       Assert.assertTrue(ultraTaskPage.addToCart.isDisplayed());
    }
    @Given("user product adding to cart")
    public void user_product_adding_to_cart() {
        ultraTaskPage.addToCart.click();
    }
    @Given("user can see inside the cart")
    public void user_can_see_inside_the_cart() {
        try {
            Assert.assertTrue(Integer.parseInt(ultraTaskPage.shoppingCount.getText())!=0);
        }catch (NoSuchElementException e){
            //e.printStackTrace();
            System.out.println("Cart is empty");
        }
    }
    @Given("remove button change to add to cart button")
    public void remove_button_change_to_add_to_cart_button() {
        Assert.assertFalse(ultraTaskPage.removeButton.isDisplayed());
    }
}
