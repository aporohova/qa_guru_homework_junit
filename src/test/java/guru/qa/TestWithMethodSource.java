package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;


public class TestWithMethodSource extends TestBase{

    static Stream<Arguments> checkMenuPage() {
        return Stream.of(
                Arguments.of(List.of("Бытовая техника", "Красота и здоровье", "Смартфоны и фототехника", "ТВ, консоли и аудио", "ПК, ноутбуки, периферия", "Комплектующие для ПК", "Офис и мебель", "Сетевое оборудование", "Отдых и развлечения", "Инструмент и стройка", "Садовая техника", "Дом, декор и посуда", "Автотовары", "Аксессуары и услуги")));
    }


    @MethodSource
    @ParameterizedTest (name = "Тестирование отображения меню страницы")

    void checkMenuPage (List<String> pages)
    {
       open("https://www.dns-shop.ru/");
       $(".homepage__catalog").shouldHave(CollectionCondition.containExactTextsCaseSensitive(pages));
    }

}
