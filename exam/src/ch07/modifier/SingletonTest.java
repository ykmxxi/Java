package ch07.modifier;

final class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {
        // ...
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }
}

public class SingletonTest {

    public static void main(String[] args) {

        // Singleton singleton = new Singleton();
        // -> Error!! Singleton() has private access in Singleton
        Singleton singleton = Singleton.getInstance();
    }

}
