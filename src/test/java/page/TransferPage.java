package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.CardInfo;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private final SelenideElement transferCardButton = $("#root > div > form > button.button.button_view_extra.button_size_s.button_theme_alfa-on-white");
    private final SelenideElement cancelTransferCardButton = $("[data-test-id=action-transfer]");
    private final SelenideElement amountTransferCard = $("[data-test-id=amount] input");
    private final SelenideElement fromTransferCard = $("[data-test-id=from] input");

    public TransferPage() {
        $("#root > div > form").shouldBe(Condition.visible);
    }

    public DashboardPage validTransferCard1(String value) {
        amountTransferCard.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        amountTransferCard.sendKeys(Keys.chord(Keys.BACK_SPACE));
        amountTransferCard.setValue(String.valueOf(value));
        fromTransferCard.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fromTransferCard.sendKeys(Keys.chord(Keys.BACK_SPACE));
        fromTransferCard.setValue(CardInfo.getCardInfo2().getCard());
        transferCardButton.click();
        return new DashboardPage();
    }

    public DashboardPage validTransferCard2(String value) {
        amountTransferCard.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        amountTransferCard.sendKeys(Keys.chord(Keys.BACK_SPACE));
        amountTransferCard.setValue(String.valueOf(value));
        fromTransferCard.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fromTransferCard.sendKeys(Keys.chord(Keys.BACK_SPACE));
        fromTransferCard.setValue(CardInfo.getCardInfo1().getCard());
        transferCardButton.click();
        return new DashboardPage();
    }

    public DashboardPage cancelButton() {
        cancelTransferCardButton.click();
        return new DashboardPage();
    }


}
