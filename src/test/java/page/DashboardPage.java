package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private final ElementsCollection transferButton = $$("[data-test-id=action-deposit]");
    private final SelenideElement refreshButton = $("[data-test-id=action-reload]");

    public DashboardPage() {
        $("[data-test-id=dashboard]").shouldBe(visible);
    }

    public TransferPage transferCard1() {
        transferButton.get(0).click();
        return new TransferPage();
    }

    public TransferPage transferCard2() {
        transferButton.get(1).click();
        return new TransferPage();
    }

    public DashboardPage refreshButton() {
        refreshButton.click();
        return new DashboardPage();
    }

    private final String balanceFinish = " р.";
    private final ElementsCollection cards = $$(".list__item div");


    public int getFistCardBalance() {
        val text = cards.first().text();

        return extractBalance(text);
    }

    public int getSecondCardBalance() {
        val text = cards.get(1).text();

        return extractBalance(text);
    }

    private int extractBalance(String text) {
        String balanceStart = "баланс: ";
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

}
