package specs;

import support.Data;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleLoginTest extends Data {

    @Test
    void loginToGoogleAccount () {
        open("/");
        $("[aria-label^='Google Account:']").shouldNot(exist);
        $("[aria-label='Sign in']").shouldBe(visible).click();
        $("[aria-label='Email or phone']").setValue("login").pressEnter();
        $("[aria-label='Enter your password']").setValue("password").pressEnter();
        $("[aria-label^='Google Account:']").shouldBe(visible);
    }
}
