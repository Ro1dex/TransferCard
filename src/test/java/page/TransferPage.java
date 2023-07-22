package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {
    private final SelenideElement transferCardButton = $$("[data-test-id=action-transfer]").first();
    private final SelenideElement cancelTransferCardButton = $$("[data-test-id=action-transfer]").last();
    private final SelenideElement amountTransferCard = $("[data-test-id=amount] input");
    private final SelenideElement fromTransferCard = $("[data-test-id=from] input");

    public TransferPage() {
        $("form").shouldBe(Condition.visible);
    }

    public  void clearFormMethod(){
        amountTransferCard.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        amountTransferCard.sendKeys(Keys.chord(Keys.BACK_SPACE));
        fromTransferCard.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fromTransferCard.sendKeys(Keys.chord(Keys.BACK_SPACE));
    }
    public DashboardPage validTransferCard(String value, String cardNumber){
        clearFormMethod();
        amountTransferCard.setValue(String.valueOf(value));
        fromTransferCard.setValue(cardNumber);
        transferCardButton.click();
        return new DashboardPage();

    }

    public DashboardPage cancelButton() {
        cancelTransferCardButton.click();
        return new DashboardPage();
    }


}
