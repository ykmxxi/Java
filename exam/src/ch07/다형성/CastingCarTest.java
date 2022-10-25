package ch07.다형성;

class Car {
    String color;
    int door;

    void drive() {
        System.out.println("Drive, Brrrrr~");

    }

    void stop() {
        System.out.println("Stop!!!, Turn off engine");

    }

}

class FireTruck extends Car {
    void water() {
        System.out.println("Water shot!!!");

    }

}

class Ambulance extends Car {
    void siren() {
        System.out.println("Siren~~~");

    }

}

public class CastingCarTest {

    public static void main(String[] args) {
        Car car = null;
        FireTruck fireTruck = new FireTruck();
        FireTruck fireTruck2 = null;
        Ambulance ambulance;

        // ambulance = (Ambulance)fireTruck;    // Error : 상속관계 X
        // fireTruck = (FireTruck)ambulance;    // Error : 상속관계 X

        fireTruck.water();
        car = fireTruck;    // Up-casting
        // car.water();    // 불가능, 인스턴스가 Car 이므로 water() 호출 X

        fireTruck2 = (FireTruck)car; // Down-casting, 명시적 형변환
        fireTruck2.water();

        Car car2 = new Car();
        Car car3 = new FireTruck();
        FireTruck fireTruck3 = null;

        // fireTruck3 = (FireTruck)car2;
        // fireTruck3.drive();    // Error, 조상타입의 인스턴스를 자손타입의 참조변수로 참조하는 것은 허용되지 않는다

        fireTruck3 = (FireTruck)car3;
        fireTruck3.drive();

    }

}
