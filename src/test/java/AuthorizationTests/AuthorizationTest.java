package AuthorizationTests;

import Authorization.AuthorizationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.BooleanSupplier;

public class AuthorizationTest extends AbstractTest{


    @DisplayName("Проверка успешной авторизации")
    @Test
    void SuccessfulAuthorization() throws InterruptedException {
        AuthorizationPage autPage = new AuthorizationPage(getWebDriver());
        autPage.setUsername("tiuleneva");
        autPage.setPassword("b902d8ce62");
        autPage.logIn();
        Thread.sleep(5000);
        Assertions.assertEquals("https://test-stand.gb.ru/",getWebDriver().getCurrentUrl());
    }

    @DisplayName("Проверка недопустимых значений логина. Граничные значения")
    @ParameterizedTest
    @ValueSource(strings = {"ti", "tiulenevatiulenevatiu"})
    void InvalidLoginAuthorization(String username) throws InterruptedException {
        AuthorizationPage autPage = new AuthorizationPage(getWebDriver());
        autPage.setUsername(username);
        autPage.setPassword("b902d8ce62");
        autPage.logIn();
        Thread.sleep(5000);
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("/html/body/div/main/div/div/div[2]/p[1]")).getText().equals("Неправильный логин. Может быть не менее 3 и не более 20 символов"));
    }

    @DisplayName("Проверка недопустимых значений логина. Спецсимволы, кириллица")
    @ParameterizedTest
    @ValueSource(strings = {"tinтюленева", "tiulen#$#@#"})
    void InvalidLoginNoValidAuthorization(String username) throws InterruptedException {
        AuthorizationPage autPage = new AuthorizationPage(getWebDriver());
        autPage.setUsername(username);
        autPage.setPassword("b902d8ce62");
        autPage.logIn();
        Thread.sleep(5000);
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("/html/body/div/main/div/div/div[2]/p[1]")).getText().equals("Неправильный логин. Может состоять только из латинских букв и цифр, без спецсимволов"));
    }

    @DisplayName("Проверка авторизации с незаполнением полей логина и пароля")
    @Test
    void NullLoginAuthorization(String username) throws InterruptedException {
        AuthorizationPage autPage = new AuthorizationPage(getWebDriver());
        autPage.logIn();
        Thread.sleep(5000);
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("/html/body/div/main/div/div/div[2]/p[1]")).getText().equals("Поле не может быть пустым"));
    }

}
