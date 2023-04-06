package MyPostsTests;


import MyPosts.MyPostsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class MyPostsTest extends AbstractTest {

    @DisplayName("Проверка сортировки ASC,DESC")
    @Test
    void SortDescPost() {
        MyPostsPage orderDesc = new MyPostsPage(getWebDriver());
        orderDesc.orderClick();
        Assertions.assertEquals("https://test-stand.gb.ru/?sort=createdAt&order=DESC",getWebDriver().getCurrentUrl());
        orderDesc.orderClick();
        Assertions.assertEquals("https://test-stand.gb.ru/?sort=createdAt&order=ASC",getWebDriver().getCurrentUrl());
    }

    @DisplayName("Проверка постраничного перехода")
    @Test
    void PaginatedPost() throws InterruptedException {
        MyPostsPage paginated = new MyPostsPage(getWebDriver());
        JavascriptExecutor js = ((JavascriptExecutor) getWebDriver());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        paginated.nextClick();
        Thread.sleep(5000);
        Assertions.assertEquals("https://test-stand.gb.ru/?page=2",getWebDriver().getCurrentUrl());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        paginated.previousClick();
        Thread.sleep(5000);
        Assertions.assertEquals("https://test-stand.gb.ru/?page=1",getWebDriver().getCurrentUrl());
    }

    @DisplayName("Проверка отображения элементов поста")
    @Test
    void ViewsPost() {
        MyPostsPage elementSearch = new MyPostsPage(getWebDriver());
        Assertions.assertTrue(elementSearch.imgDisplayed());
        Assertions.assertTrue(elementSearch.nameDisplayed());
        Assertions.assertTrue(elementSearch.descriptionDisplayed());
    }

    @DisplayName("Проверка перехода к чужим постам")
    @Test
    void NotMyPost() throws InterruptedException {
        MyPostsPage notMy = new MyPostsPage(getWebDriver());
        notMy.notMyPostClick();
        Thread.sleep(5000);
        Assertions.assertEquals("https://test-stand.gb.ru/?owner=notMe&sort=createdAt&order=ASC",getWebDriver().getCurrentUrl());
    }


}
