package avci.murat.step_definitions;

import avci.murat.pages.YouTubeImgPage;
import avci.murat.utilities.BrowserTools;
import avci.murat.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class YouTubeImg {
    YouTubeImgPage youTubeImgPage=new YouTubeImgPage();

    @Given("open browser and go to youtube channel")
    public void openBrowserAndGoToYoutubeChannel() {
        //Driver.getWebDriver().navigate().to("https://www.youtube.com/@PythonSimplified");
        Driver.getWebDriver().navigate().to("https://www.youtube.com/@sina5an");
    }
    @When("go to the videos tab")
    public void goToTheVideosTab() {
        youTubeImgPage.videos.click();
    }
//
    @And("find the latest video and get your picture")
    public void findTheLatestVideoAndGetYourPicture() throws IOException {
        String imageURL=youTubeImgPage.sinan_img.getAttribute("src");
        String imgPath="C:\\Users\\murat\\OneDrive\\Belgeler\\resim.png";
        BrowserTools.saveImageFromURL(imageURL,imgPath);
    }
}

