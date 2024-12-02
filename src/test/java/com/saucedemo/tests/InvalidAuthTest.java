package com.saucedemo.tests;

import com.saucedemo.data.LoginAlerts;
import com.saucedemo.data.LogoutAlerts;
import com.saucedemo.data.Username;
import com.saucedemo.jupiter.CookieLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InvalidAuthTest extends TestBase {

    @Test
    @DisplayName("Should not authorize with locked out user")
    void loginWithLockedOutUser() {
        loginPage
                .setManuallyAuthFieldsAndPressLogin("locked_out_user", "secret_sauce")
                .invalidUserAuthorisationAssertion(LoginAlerts.LOCKED_OUT_USER_ALERT);
    }

    @Test
    @DisplayName("Should not authorize without credentials")
    void loginWithoutCredentials() {
        loginPage
                .setManuallyAuthFieldsAndPressLogin("","")
                .invalidUserAuthorisationAssertion(LoginAlerts.INVALID_USERNAME_ALERT);
    }

    @Test
    @DisplayName("Should not authorize with invalid credentials")
    void loginWithInvalidCredentials() {
        loginPage
                .setManuallyAuthFieldsAndPressLogin("asdasd", "asdasdad")
                .invalidUserAuthorisationAssertion(LoginAlerts.INVALID_USERNAME_AND_PASSWORD_ALERT);
    }

    @CookieLogin(username = Username.locked_out_user)
    @Test
    @DisplayName("Should not navigate to inventory page when trying to login with locked out user via cookies")
    void navigateToInventoryPageWithLockedUserViaCookies() {
        loginPage.loggedOutUserAssertion(LogoutAlerts.INVENTORY_PAGE_ALERT);

    }

    @CookieLogin(username = Username.locked_out_user, url = "inventory-item.html?id=4")
    @Test
    @DisplayName("Should not navigate to inventory page when trying to login with locked out user via cookies")
    void navigateToItemPageWithLockedUserViaCookies() {
        loginPage.loggedOutUserAssertion(LogoutAlerts.INVENTORY_ITEM_PAGE_ALERT);

    }

    @CookieLogin(username = Username.locked_out_user, url = "cart.html")
    @Test
    @DisplayName("Should not navigate to cart page when trying to login with locked out user via cookies")
    void navigateToCartPageWithLockedUserViaCookies() {
        loginPage.loggedOutUserAssertion(LogoutAlerts.CART_PAGE_ALERT);

    }

    @CookieLogin(username = Username.locked_out_user, url = "checkout-step-one.html")
    @Test
    @DisplayName("Should not navigate to checkout stage one page when trying to login with locked out user via cookies")
    void navigateToCheckoutStageOnePageWithLockedUserViaCookies() {
        loginPage.loggedOutUserAssertion(LogoutAlerts.YOUR_INFORMATION_CHECKOUT_PAGE_ALERT);

    }

    @CookieLogin(username = Username.locked_out_user, url = "checkout-step-two.html")
    @Test
    @DisplayName("Should not navigate to checkout stage two page when trying to login with locked out user via cookies")
    void navigateToCheckoutStageTwoPageWithLockedUserViaCookies() {
        loginPage.loggedOutUserAssertion(LogoutAlerts.OVERVIEW_CHECKOUT_PAGE_ALERT);

    }

    @CookieLogin(username = Username.locked_out_user, url = "checkout-complete.html")
    @Test
    @DisplayName("Should not navigate to checkout complete page when trying to login with locked out user via cookies")
    void navigateToCheckoutCompletePageWithLockedUserViaCookies() {
        loginPage.loggedOutUserAssertion(LogoutAlerts.COMPLETE_CHECKOUT_PAGE_ALERT);

    }
}
