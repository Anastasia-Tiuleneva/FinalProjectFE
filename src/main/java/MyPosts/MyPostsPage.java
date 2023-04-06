package MyPosts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPostsPage extends AbstractPage{

    @FindBy(xpath = "/html/body/div[1]/main/div/div[2]/div[2]/div[1]/button")
    private WebElement order;

    @FindBy(xpath = "/html/body/div[1]/main/div/div[3]/div[2]/div/a[1]")
    private WebElement previousPage;

    @FindBy(xpath = "/html/body/div[1]/main/div/div[3]/div[2]/div/a[2]")
    private WebElement nextPage;


    @FindBy(xpath = "/html/body/div[1]/main/div/div[3]/div[1]/a[1]")
    private WebElement post;

    @FindBy(xpath = "/html/body/div[1]/main/div/div[3]/div[1]/a[1]/img")
    private WebElement imgPost;

    @FindBy(xpath = "/html/body/div[1]/main/div/div[3]/div[1]/a[1]/h2")
    private WebElement namePost;

    @FindBy(xpath = "/html/body/div[1]/main/div/div[3]/div[1]/a[1]/div")
    private WebElement descriptionPost;

    @FindBy(xpath = "/html/body/div[1]/main/div/div[2]/div[2]/div[2]/label/span")
    private WebElement notMyPost;

    public  void notMyPostClick(){
        this.notMyPost.click();
    }

    public  boolean imgDisplayed(){
        return this.imgPost.isDisplayed();
    }

    public  boolean nameDisplayed(){
        return this.namePost.isDisplayed();
    }
    public  boolean descriptionDisplayed(){
        return this.descriptionPost.isDisplayed();
    }

    public  void orderClick(){
        this.order.click();
    }

    public  void previousClick(){
        this.previousPage.click();
    }

    public  void nextClick(){
        this.nextPage.click();
    }


    public MyPostsPage(WebDriver driver) {
        super(driver);
    }
}
