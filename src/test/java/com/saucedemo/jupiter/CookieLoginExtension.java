package com.saucedemo.jupiter;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;
import org.openqa.selenium.Cookie;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.open;

public class CookieLoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Optional<CookieLogin> annotation = AnnotationSupport.findAnnotation(context.getRequiredTestMethod(), CookieLogin.class);

        if (annotation.isPresent()) {
            CookieLogin cookieLogin = annotation.get();

            String username = cookieLogin.username().name();
            Date expdate = Date.from(Instant.now().plus(cookieLogin.cookieLifeTimeInSeconds(), ChronoUnit.SECONDS));
            Cookie cookie = new Cookie("session-username", username, "/", expdate);
            WebDriverRunner.getWebDriver().manage().addCookie(cookie);
            open(cookieLogin.url());
        }
    }
}
