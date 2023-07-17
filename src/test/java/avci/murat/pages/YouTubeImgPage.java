package avci.murat.pages;

import avci.murat.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YouTubeImgPage {
    public YouTubeImgPage(){
        PageFactory.initElements(Driver.getWebDriver(),this);
    }

//

    @FindBy(xpath = "//img[contains(@class,'yt-core-image')]")
    public List<WebElement> videoImages;

    @FindBy (xpath = "//*[@src='https://i.ytimg.com/vi/hebTN9kCPt8/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDnvLvR1uJkn38e3Mrr0Rw0sMnZ1Q']")
    public WebElement sinan_img;

    @FindBy(id="search")
    public WebElement searchArea;

    @FindBy(id = "search-icon-legacy")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"tabsContent\"]/tp-yt-paper-tab[2]/div")
    public WebElement videos;
}
