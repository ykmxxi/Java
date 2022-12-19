package ch07.다형성;

public class InstanceofTest {

    void doWork(FireTruck firetruck) {
        if (firetruck instanceof FireTruck) {
            System.out.println("This is a FireTruck instance.");
        }

        if (firetruck instanceof Car) {
            System.out.println("This is a Car instance.");
        }

        if (firetruck instanceof Object) {
            System.out.println("This is an Object instance.");
        }

        System.out.println(firetruck.getClass().getName());     // 클래스 이름 출력
    }

    public static void main(String[] args) {

        FireTruck fireTruck = new FireTruck();

        InstanceofTest instanceofTest = new InstanceofTest();
        instanceofTest.doWork(fireTruck);

    }
}
