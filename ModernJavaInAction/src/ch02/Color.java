package ch02;

public enum Color {
    GREEN("GREEN"),
    RED("RED");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
