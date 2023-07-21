package data;

import lombok.Value;

public class CardInfo {
    @Value
    public static class Card1 {
        String card;
    }
    @Value
    public static class Card2 {
        String card;
    }

    public static Card1 getCardInfo1() {
        return new Card1("5559 0000 0000 0001");
    }
    public static Card2 getCardInfo2() {
        return new Card2("5559 0000 0000 0002");
    }
}

