package ch07.클래스간관계결정;

class Shape {

    String color = "black";

    void draw() {
        System.out.printf("[color = %s]%n", color);
    }

}

class Point {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point() {
        this(0, 0);
    }

    String getXY() {
        return "(" + x + ", " + y + ")";
    }


}

// Circle is a Shape
class Circle extends Shape {

    Point center;   // 원점 좌표, Circle has a Point
    int radius;

    Circle() {
        this(new Point(0, 0), 100);
    }

    Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    void draw() {
        System.out.printf("[center = (%d, %d), r = %d, color = %s]%n",
                center.x, center.y, radius, color);

    }

}

// Triangle is a Shape
class Triangle extends Shape {

    Point[] points = new Point[3]; // Triangle has a Point

    Triangle(Point[] points) {
        this.points = points;
    }

    void draw() {
        System.out.printf("[point1 = %s, point2 = %s, point3 = %s, color = %s]%n",
                points[0].getXY(), points[1].getXY(), points[2].getXY(), color);
    }

}

public class DrawShape {

    public static void main(String[] args) {

        Point[] p = {new Point(100, 100),
                new Point(140, 50),
                new Point(200, 100)
        };

        Triangle t = new Triangle(p);
        Circle c = new Circle(new Point(150, 150), 50);

        t.draw(); // 삼각형을 그린다.
        c.draw(); // 원을 그린다.
    }

}
