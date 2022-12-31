package ch02.동작파라미터화;

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
