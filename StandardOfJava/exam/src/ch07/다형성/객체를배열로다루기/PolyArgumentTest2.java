package ch07.다형성.객체를배열로다루기;

import java.util.ArrayList;

class Product {
    int price;
    int bonusPoint;

    public Product() {
        price = 0;
        bonusPoint = 0;
    }

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

class Audio extends Product {
    public Audio() {
        super(50);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    ArrayList<Product> item = new ArrayList<>();

    public void buy(Product product) {
        if (money < product.price) {
            System.out.println("잔액이 부족합니다.");
        }
        money -= product.price;
        bonusPoint += product.bonusPoint;
        item.add(product);
        System.out.println(product + "구매 하셨습니다.");
    }

    public void refund(Product product) {
        if (item.remove(product)) {
            money += product.price;
            bonusPoint -= product.bonusPoint;
            System.out.println(product + "를 환불 했습니다.");
        }
        if (!item.remove(product)) {
            System.out.println("구입 목록에 해당 제품이 없습니다.");
        }
    }

    public void summary() {
        int sum = 0;
        String itemList = "";

        if (item.isEmpty()) {
            System.out.println("구입한 제품이 없습니다.");
        }

        for (int i = 0; i < item.size(); i++) {
            Product product = (Product) item.get(i);
            sum += product.price;
            itemList += (i == 0) ? "" + product : ", " + product;
        }
        System.out.println("구입한 물품의 총액은 " + sum);
        System.out.println("구입한 제품은 " + itemList);
    }
}


public class PolyArgumentTest2 {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        Tv tv = new Tv();
        Computer computer = new Computer();
        Audio audio = new Audio();

        buyer.buy(tv);
        buyer.buy(computer);
        buyer.buy(audio);
        buyer.summary();
        System.out.println();
        buyer.refund(computer);
        buyer.summary();
    }
}

