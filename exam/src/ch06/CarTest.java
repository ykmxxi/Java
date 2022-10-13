package ch06;

class Car implements Cloneable {

    String color;
    String gearType;
    int door;

    Car() {
        this("white", "auto", 4);
    }

    Car(String color, String gearType, int door) {

        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    // 인스턴스 복사를 위한 생성자
     Car(Car c) {
        color = c.color;
        gearType = c.gearType;
        door = c.door;
     }

}

public class CarTest {

    public static void main(String[] args) {

        Car car1 = new Car();
        Car car2 = new Car("black", "auto", 2);
        Car car3 = car1.clone();
        Car car4 = new Car(car2);

        System.out.println("car1's information : " + car1.color + ", " + car1.gearType + ", " + car1.door);
        System.out.println("car2's information : " + car2.color + ", " + car2.gearType + ", " + car2.door);
        System.out.println("car3's information : " + car3.color + ", " + car3.gearType + ", " + car3.door);
        System.out.println("car4's information : " + car4.color + ", " + car4.gearType + ", " + car4.door);

        System.out.println("=============================");
        car1.color = "blue";

        // car2는 car1 을 복사하여 생성된 것이지만, 서로 독립된 메모리공간에 존재하는 별도의 인스턴스이므로 서로 영향을 미치지 않는다
        System.out.println("car1's information : " + car1.color + ", " + car1.gearType + ", " + car1.door);
        System.out.println("car3's information : " + car3.color + ", " + car3.gearType + ", " + car3.door);

    }
}
