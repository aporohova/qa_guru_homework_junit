package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeEach
     void beforeAll () {
        Configuration.baseUrl = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
}
