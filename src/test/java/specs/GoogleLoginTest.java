package specs;

import support.Config;
import pages.App;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleLoginTest extends Config {

    @Test
    @DisplayName("Google Authorization 1")
    void loginToGoogleAccount () {
        open("/");
        $(App.signed_in_label).shouldNot(exist);
        $(App.sign_in_button).shouldBe(visible).click();
        $(App.login_field).setValue("login").pressEnter();
        $(App.password_field).setValue("password").pressEnter();
        $(App.signed_in_label).shouldBe(visible);
    }
}
