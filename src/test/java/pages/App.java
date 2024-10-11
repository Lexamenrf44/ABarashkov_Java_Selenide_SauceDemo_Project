package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class App {

    //HelpMethods
    public ElementsCollection getResults() {
        return $$("[data-testid=\"result\"]");
    }

    public SelenideElement getResult(int index) {
        return $("#r1-" + index);
    }

    public void searchFor(String text) {
        $(By.name("q")).val(text).pressEnter();
    }

    //Common
    public static final String signed_in_label = "[aria-label^='Google Account:']";

    //Buttons
    public static final String sign_in_button = "[aria-label='Sign in']";
    public static final String login_next_button = "#identifierNext";
    public static final String password_next_button = "#passwordNext";

    //Fields
    public static final String login_field = "[aria-label='Email or phone']";
    public static final String password_field = "[aria-label='Enter your password']";
}
