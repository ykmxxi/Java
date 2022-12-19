package ch09.lang패키지;

class Card {
    String kind;
    int number;

    public Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override
    public String toString() {
        return "kind = " + kind + ", number = " + number;
    }
}

public class CardToString {
    public static void main(String[] args) {
        Card card1 = new Card("SPADE", 3);
        Card card2 = new Card("HEART", 8);

        System.out.println(card1.toString());
        System.out.println(card2.toString());
    }
}
