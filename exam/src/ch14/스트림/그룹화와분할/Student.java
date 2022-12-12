package ch14.스트림.그룹화와분할;

public class Student {
    private final String name;
    private final boolean isMale;
    private final int grade;
    private final int classNumber;
    private final int score;

    public Student(String name, boolean isMale, int grade, int classNumber, int score) {
        this.name = name;
        this.isMale = isMale;
        this.grade = grade;
        this.classNumber = classNumber;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getGrade() {
        return grade;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남자" : "여자", grade, classNumber, score);
    }

    enum Level {HIGH, MID, LOW} // 성적: 상, 중, 하
}
