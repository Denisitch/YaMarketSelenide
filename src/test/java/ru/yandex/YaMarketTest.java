package ru.yandex;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.YaMarketMainPage;
import pages.YaMarketSubtitlePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static helpers.Properties.testsProperties;

/**
 * @author Осюшкин Денис
 * Класс тестов, тесты разбиты на step'ы, для проверки результатов поиска в YandexMarket
 */
public class YaMarketTest {

    /**
     * @author Осюшкин Денис
     * Тест для проверки результатов поиска в YandexMarket c помощью паттерна Page Object Selenide
     * @param titleCatalogItem название искомой категории в каталоге
     * @param titleCatalogSubitem название искомой подкатегории в каталоге
     * @param titleFiltersCheckbox название фильтра с чекбокс
     * @param titleSubfilters критерий фильтра чекбокс
     */
    @Feature("Проверка результатов поиска в YandexMarket")
    @DisplayName("Переход на страницу подпункта каталога  и поиск смартфона определенного производителя")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#dataProvider")
    public void testYM(
            String titleCatalogItem, String titleCatalogSubitem, String titleFiltersCheckbox, String titleSubfilters
    ) {
        open(testsProperties.yandexMarketUrl(), YaMarketMainPage.class)
                .hoverToItem(titleCatalogItem)
                .searchCatalogSubitem(titleCatalogSubitem, YaMarketSubtitlePage.class);
        sleep(3000);
    }
}
