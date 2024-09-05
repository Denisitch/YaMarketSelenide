package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static helpers.Assertions.fail;

/**
 * @author Осюшкин Денис
 * Класс, характеризующий начальную страницу сайта YandexMarket
 */
public class YaMarketMainPage extends BasePage {

    /**
     * Селектор кнопки каталога
     */
    private static final String CATALOG_BUTTON =
            "//div[@data-zone-name='catalog']/button";

    /**
     * Селектор названий элементов каталога
     */
    private static final String CATALOG_ITEMS =
            "//div[@data-zone-name='catalog-content']//ul[@role='tablist']//descendant::span";

    /**
     * Селектор названий подэлементов каталога
     */
    private static final String CATALOG_SUBITEMS =
            "//div[@data-auto='category']//ul[@data-autotest-id='subItems']//a";

    /**
     * Селектор названий заголовков подэлементов каталога
     */
    private static final String CATALOG_HEAD_SUBITEMS =
            "//div[@data-auto='category']//ancestor::div[@role='heading']/a";

    /**
     * @author Осюшкин Денис
     * Метод, в котором происходит выбор категории из каталога
     * @param titleCatalogItem название искомой категории в каталоге
     * @return YaMarketMainPage
     */
    @Step("Поиск подкатегории {titleCatalogItem}")
    public YaMarketMainPage hoverToItem (String titleCatalogItem) {
        $x(CATALOG_BUTTON).click();
        $x(CATALOG_ITEMS).shouldBe(visible);
        $$x(CATALOG_ITEMS).stream()
                .filter(item -> item.getText().equals(titleCatalogItem))
                .findFirst()
                .ifPresentOrElse(
                        SelenideElement::hover,
                        () -> fail(titleCatalogItem + " отсутствует в заголовках каталога")
                );
        return this;
    }

    /**
     * @author Осюшкин Денис
     * Метод, в котором происходит поиск нужной подкатегории в каталоге
     * @param titleCatalogSubitem название искомой подкатегории в каталоге
     * @param typeNextPage класс возвращаемой веб-страницы
     * @return <T extends BasePage>
     * @param <T> класс, наследник базовой веб-страницы
     */
    @Step("Поиск подкатегории {titleCatalogSubitem}")
    public <T extends BasePage> T searchCatalogSubitem (String titleCatalogSubitem, Class<T> typeNextPage) {
        $$x(CATALOG_SUBITEMS).stream()
                .filter(subitem -> subitem.getText().equals(titleCatalogSubitem))
                .findFirst()
                .ifPresentOrElse(
                        selenideElement -> {
                            $x(CATALOG_HEAD_SUBITEMS).shouldBe(visible);
                            selenideElement.click();
                        },
                        () -> fail(titleCatalogSubitem + " отсутствует в подкатегориях каталога")
                );

        return typeNextPage.cast(page(typeNextPage));
    }
}
