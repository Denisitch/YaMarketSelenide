package ru.yandex;

import allure.CustomAllureSelenide;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author Осюшкин Денис
 * Базовый класс для тестов
 */
public class BaseTest {

    /**
     * @author Осюшкин Денис
     * Метод, выполняющийся перед началом каждого теста
     */
    @BeforeAll
    public static void setUp() {
        Configuration.pageLoadStrategy = "normal";

        SelenideLogger.addListener("AllureSelenide",
                new CustomAllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }
}
