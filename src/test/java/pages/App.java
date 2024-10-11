package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class App {

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

}
