package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private final SelenideElement header = $("[data-test-id=dashboard]");
    private final SelenideElement transferButton1 = $("#root > div > ul > li:nth-child(1) > div > button");
    private final SelenideElement transferButton2 = $("#root > div > ul > li:nth-child(2) > div > button");
    private final SelenideElement refreshButton = $("[data-test-id=action-reload]");

    public DashboardPage(){
        header.shouldBe(visible);
    }
    public TransferPage TransferCard1(){
        transferButton1.click();
        return new TransferPage();
    }
    public TransferPage TransferCard2(){
        transferButton2.click();
        return new TransferPage();
    }
    public DashboardPage refreshButton(){
        refreshButton.click();
        return new DashboardPage();
    }

    private final String balanceFinish = " р.";
    private final ElementsCollection cards = $$(".list__item div");
   public String getFistIDCard(){
        val id = cards.first().getAttribute("data-test-id");
        return String.valueOf(getFistCardBalance());
    }
    public String getSecondIDCard(){
        val id = cards.get(1).getAttribute("data-test-id");
        return String.valueOf(getSecondCardBalance());
    }

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
