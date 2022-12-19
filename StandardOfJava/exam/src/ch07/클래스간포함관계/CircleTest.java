package ch07.클래스간포함관계;

class Point {

    int x;
    int y;

}

class Circle {

    Point point = new Point();
    int radius;

}

class CircleTest {

    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.point.x = 10;
        circle.point.y = 10;
        circle.radius = 5;

    }
}




