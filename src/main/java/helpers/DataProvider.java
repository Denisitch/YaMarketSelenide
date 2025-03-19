package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author Осюшкин Денис
 * Класс, предоставляющий входные данные для тестов
 */
public class DataProvider {

    /**
     * @author Осюшкин Денис
     * Метод, в который передаются входные данные для тестов
     * @return Stream<Arguments>
     */
    public static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        "Электроника", "Смартфоны", "Бренд", "Apple"
                )
        );
    }
}
