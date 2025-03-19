package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

/**
 * @author Осюшкин Денис
 * Базовый класс для загружаемых веб-страниц
 */
public class BasePage {
    protected void pastClick() {
        $x("//*[@id=\"/marketfrontDynamicPopupLoader42/content\"]//a").shouldBe(visible);
        actions().moveByOffset(10, 10).click().perform();
    }
}
