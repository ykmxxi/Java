package ch06;

public class CardTest {

    public static void main(String[] args) {

        System.out.println("Card.width = " + Card.width);
        System.out.println("Card.height = " + Card.height);

        Card card1 = new Card();
        card1.kind = "Heart";
        card1.number = 7;

        Card card2 = new Card();
        card2.kind = "Spade";
        card2.number = 3;

        System.out.println("card1 정보 : " + card1.kind + card1.number);
        System.out.println("card2 정보 : " + card2.kind + card2.number);

        System.out.println("기존 카드 규격 : " + Card.width + " / " + Card.height);
        System.out.println("카드 규격 수정, 카드 규격은 클래스변수로 수정시 모든 인스턴스의 정보도 수정");
        Card.width = 40;
        Card.height = 100;

        System.out.println("card1 규격 : " + card1.width + " / " + card1.height);
        System.out.println("card2 규격 : " + card2.width + " / " + card2.height);
    }
}
