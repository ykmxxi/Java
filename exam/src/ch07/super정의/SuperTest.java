package ch07.super정의;

class Parent {
    int x = 10;
}

class Child extends Parent {
    int x = 20;

    void method() {
        System.out.println("x = " + x);                 // 20
        System.out.println("this.x = " + this.x);       // 20
        System.out.println("super.x = " + super.x);     // 10
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getLocation() {
        return "x : " + x + ", y : " + y;
    }
}

class Point3D extends Point {
    int z;

    Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    String getLocation() {
        return super.getLocation() + ", z : " + z;
    }
}

public class SuperTest {

    public static void main(String[] args) {

        Child child = new Child();
        child.method();

        Point3D point3D = new Point3D(3, 3, 3);
        System.out.println(point3D.getLocation());
    }
}
