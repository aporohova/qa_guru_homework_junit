package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.*;

public class TestWithFileSource extends TestBase{
    @CsvFileSource (resources = "/testData.csv")
    @DisplayName("Тесты на сайт авито")

    @ParameterizedTest(name = "При поиске марки {0} на странице отображается модель {1}")

    @Tags ({
        @Tag("Blocker"),
        @Tag("AvitoTets")
    })


    void checkBrandDisplaying(
        String CarBrand,
        String CarModel
    ){
        open("https://www.avito.ru/");
        $(".index-suggest-zkzTd").click();
        $(".input-input-Zpzc1").setValue(CarBrand).pressEnter();
        sleep(2000);
        $(".popular-rubricator-root-Mo5uC").shouldHave(Condition.text(CarModel));


    }

}

