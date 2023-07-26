
import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        open("http://localhost:9999");
        int value = 1000;
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor();
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var expectedFirstBalanceFirstCard = dashboardPage.getFistCardBalance() + value;
        var expectedFirstBalanceSecondCard = dashboardPage.getSecondCardBalance() - value;
        var transferPageCardFirst = dashboardPage.transferCard1();
        transferPageCardFirst.validTransferCard(String.valueOf(value), DataHelper.getCardInfo2().getCard());
        var actualFirstBalanceFirstCard = dashboardPage.getFistCardBalance();
        var actualFirstBalanceSecondCard = dashboardPage.getSecondCardBalance();
        assertEquals(expectedFirstBalanceFirstCard, actualFirstBalanceFirstCard);
        assertEquals(expectedFirstBalanceSecondCard, actualFirstBalanceSecondCard);
        var expectedSecondBalanceSecondCard = dashboardPage.getSecondCardBalance() + value;
        var expectedSecondBalanceFirstCard = dashboardPage.getFistCardBalance() - value;
        var transferPageCardSecond = dashboardPage.transferCard2();
        transferPageCardSecond.validTransferCard(String.valueOf(value), DataHelper.getCardInfo1().getCard());
        var actualSecondBalanceSecondCard = dashboardPage.getSecondCardBalance();
        var actualSecondBalanceFirstCard = dashboardPage.getFistCardBalance();
        assertEquals(expectedSecondBalanceSecondCard, actualSecondBalanceSecondCard);
        assertEquals(expectedSecondBalanceFirstCard, actualSecondBalanceFirstCard);
        dashboardPage.refreshButton();

    }
}
