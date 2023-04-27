package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static com.codeborne.selenide.Selenide.*;

public class TestWithSource extends TestBase{
    @CsvSource({
            "Купить дом, Продажа домов",
            "Купить айфон, Объявления по запросу «Купить айфон»"
    }

    )
    @DisplayName("Тесты на корректный заголовк при поиске")

    @ParameterizedTest(name = "При поиске {0} на странице отображается заголовок {1}")
    @Tags({
            @Tag("Blocker"),
            @Tag("HeaderTest")
    })

    void checkHeaderDisplaying(
        String searchInput,
        String headerResult
        ){
        open("https://www.avito.ru");
        $(".index-suggest-zkzTd").click();
        $(".input-input-Zpzc1").setValue(searchInput).pressEnter();
        $(".page-title-root-cK8oN").shouldHave(Condition.text(headerResult));


    }


    }

