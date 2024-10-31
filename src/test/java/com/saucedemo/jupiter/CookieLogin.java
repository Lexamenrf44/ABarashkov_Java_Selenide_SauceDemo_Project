package com.saucedemo.jupiter;


import com.saucedemo.data.Username;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ExtendWith(CookieLoginExtension.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CookieLogin {
    Username username() default Username.standard_user;

    String url() default "inventory.html";

    int cookieLifeTimeInSeconds() default 300;
}
