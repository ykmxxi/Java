package ch07.modifier;

class Card {

    // 상수를 선언과 동시에 초기화 하지 않고 생성자에서 단 한번만 초기화
    final int NUMBER;
    final String KIND;
    static int width = 100;
    static int height = 250;

    Card(String kind, int number) {
        // 매개변수로 넘겨받은 값으로 상수를 초기화
        KIND = kind;
        NUMBER = number;
    }

    Card() {
        this("HEART", 1);
    }

    public String toString() {
        return KIND + " " + NUMBER;
    }
}

public class FinalCardTest {

    public static void main(String[] args) {

        Card card = new Card("HEART", 10);
        // card.NUMBER = 5; -> cannot assign a value to final variable NUMBER

        System.out.println(card.KIND);
        System.out.println(card.NUMBER);
        //System.out.println(card.toString());
        System.out.println(card);
    }
}
