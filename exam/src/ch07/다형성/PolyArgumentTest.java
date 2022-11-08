package ch07.다형성;

class Product {
    int price;
    int bonusPoint;

    public Product(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0);  // 10% 보너스
    }
}

class Tv extends Product {
    public Tv() {
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer extends Product {
    public Computer() {
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;

    public void buy(Product product) {
        if (money < product.price) {
            System.out.println("잔액이 부족합니다.");
        }
        money -= product.price;
        bonusPoint += product.bonusPoint;
        System.out.println(product + "구매 하셨습니다.");
    }
}


public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        buyer.buy(new Tv());
        buyer.buy(new Computer());

        System.out.println("현재 남은 돈은 " + buyer.money);
        System.out.println("적립된 보너스 포인트는 " + buyer.bonusPoint);
    }
}

