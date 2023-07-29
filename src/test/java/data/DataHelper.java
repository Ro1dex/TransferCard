package data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
    @Value
    public static class Card {
        String card;
    }


    public static Card getCardInfo1() {
        return new Card("5559 0000 0000 0001");
    }
    public static Card getCardInfo2() {
        return new Card("5559 0000 0000 0002");
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static VerificationCode getVerificationCodeFor() {
        return new VerificationCode("12345");

    }

}
