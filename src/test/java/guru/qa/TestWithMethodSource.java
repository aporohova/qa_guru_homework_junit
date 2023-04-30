package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;


public class TestWithMethodSource extends TestBase{

    static Stream<Arguments> checkMenuPage() {
        return Stream.of(
    Arguments.of(List.of("Акции", "Магазины", "Покупателям", "Юридическим лицам", "Клуб DNS")));
    }


    @MethodSource
    @ParameterizedTest (name = "Тестирование отображения меню страницы")

    void checkMenuPage (List<String> pages)
    {
       open("https://www.dns-shop.ru/");
       $$(".header-top-menu__common-item").filter(Condition.visible).shouldHave(CollectionCondition.containExactTextsCaseSensitive(pages));
    }

}
