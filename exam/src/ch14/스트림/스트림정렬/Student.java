package ch14.스트림.스트림정렬;

public class Student implements Comparable<Student> {
    private final String name;
    private final int classNumber;
    private final int totalScore;

    public Student(String name, int classNumber, int totalScore) {
        this.name = name;
        this.classNumber = classNumber;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, classNumber, totalScore);
    }
}
