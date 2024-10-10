package google_login.test_configuration;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;

public class TestConfiguration {

    @BeforeAll
    public static void browserOpeningConfiguration() {

        Configuration.baseUrl = "https://www.google.com/";

        open("/");

        // Clear browser cookies and local storage before starting tests
        clearBrowserCookies();
        clearBrowserLocalStorage();

        // You can set additional configuration options here if needed
        Configuration.browser = "chrome";  // Optional: Specify the browser to use
        Configuration.timeout = 10000;      // Set default timeout for actions
    }
}
