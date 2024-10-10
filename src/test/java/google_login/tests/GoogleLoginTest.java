package google_login.tests;

import google_login.test_configuration.TestConfiguration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GoogleLoginTest extends TestConfiguration {

    @Test
    void useGoogleSearch () {
        sleep(3000);  // Wait for 5 seconds
        $("[aria-label='Sign in']").shouldBe(visible).click();
        sleep(3000);  // Wait for 10 seconds
        $("[aria-label='Email or phone']").setValue("abarashkov.test01@gmail.com");
        sleep(3000);  // Wait for 10 seconds
    }
}
