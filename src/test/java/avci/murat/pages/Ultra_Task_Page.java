package avci.murat.pages;

import avci.murat.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Ultra_Task_Page {

    public Ultra_Task_Page(){
        PageFactory.initElements(Driver.getWebDriver(),this);
    }

    @FindBy(id = "user-name")
    public WebElement userinput;

    @FindBy(id = "password")
    public WebElement passinput;

    @FindBy(id = "login-button")
    public WebElement logButton;

    @FindBy(className = "title")
    public WebElement mainPageTitle;

    @FindBy(className = "error-button")
    public WebElement errorMessage;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> itemTitle;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemPrice;

    @FindBy(className = "product_sort_container")
    public WebElement sortSelect;

   @FindBy(id = "react-burger-menu-btn")
    public WebElement leftMenuButton;

   @FindBy (id = "reset_sidebar_link")
    public WebElement resetButton;

   @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCart;

   @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCart;

   @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCount;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeButton;



}
