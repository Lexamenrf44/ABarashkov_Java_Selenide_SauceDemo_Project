package com.saucedemo.web.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NavbarComponent {
    private final SelenideElement self = $(".bm-item-list");
    private final SelenideElement
            burgerMenuButton = $("[id='react-burger-menu-btn']"),
            closeNavbarButton = $("[data-test='close-menu']"),
            logoutNavbarButton = $("[data-test='logout-sidebar-link']");

    @Step("Click logout button from navigation bar")
    public NavbarComponent clickLogoutButton() {
        openNavbar();
        logoutNavbarButton.click();
        return this;
    }

    @Step("Open navigation bar")
    public NavbarComponent openNavbar() {
        burgerMenuButton.click();
        waitUntilNavbarIsLoaded();
        return this;
    }

    @Step("Close navigation bar")
    public NavbarComponent closeNavbar() {
        burgerMenuButton.click();
        waitUntilNavbarIsLoaded();
        closeNavbarButton.click();
        self.shouldNotBe(visible);
        return this;
    }

    @Step("Wait until navigation sidebar is loaded")
    public NavbarComponent waitUntilNavbarIsLoaded() {
        self.shouldBe(visible);
        return this;
    }
}
