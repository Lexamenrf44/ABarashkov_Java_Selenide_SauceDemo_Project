package support;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;

public class Data {

    @BeforeAll
    public static void browserOpeningConfiguration() {

        Configuration.baseUrl = "https://www.google.com/";
    }
}
