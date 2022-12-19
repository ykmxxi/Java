package ch14.스트림.그룹화와분할;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class GroupingTest {
    public static void main(String[] args) {
        Student[] students = {
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),

                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200)
        };

        System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
        Map<Integer, List<Student>> studentByClassNumber = Stream.of(students)
                .collect(groupingBy(Student::getClassNumber));

        for (List<Student> ban : studentByClassNumber.values()) {
            for (Student s : ban) {
                System.out.println(s);
            }
        }

        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
        Map<Student.Level, List<Student>> studentByLevel = Stream.of(students)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) {
                        return Student.Level.HIGH;
                    } else if (s.getScore() >= 100) {
                        return Student.Level.MID;
                    } else {
                        return Student.Level.LOW;
                    }
                }));

        TreeSet<Student.Level> keySet = new TreeSet<>(studentByLevel.keySet());

        for (Student.Level key : keySet) {
            System.out.println("[" + key + "]");

            for (Student s : studentByLevel.get(key)) {
                System.out.println(s);
            }
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
        Map<Student.Level, Long> studentCountByLevel = Stream.of(students)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) {
                        return Student.Level.HIGH;
                    } else if (s.getScore() >= 100) {
                        return Student.Level.MID;
                    } else {
                        return Student.Level.LOW;
                    }
                }, counting()));

        for (Student.Level key : studentCountByLevel.keySet()) {
            System.out.printf("[%s] - %d명, ", key, studentCountByLevel.get(key));
        }
        System.out.println();

        System.out.printf("%n4. 다중그룹화(학년별, 반별)%n");
        Map<Integer, Map<Integer, List<Student>>> studentByGradeAndClassNumber =
                Stream.of(students)
                        .collect(groupingBy(Student::getGrade,
                                groupingBy(Student::getClassNumber)
                        ));

        for (Map<Integer, List<Student>> hak : studentByGradeAndClassNumber.values()) {
            for (List<Student> ban : hak.values()) {
                System.out.println();
                for (Student s : ban) {
                    System.out.println(s);
                }
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student>> topStudentByGradeAndClassNumber = Stream.of(students)
                .collect(groupingBy(Student::getGrade,
                        groupingBy(Student::getClassNumber,
                                collectingAndThen(
                                        maxBy(comparingInt(Student::getScore)),
                                        Optional::get
                                )
                        )
                ));

        for (Map<Integer, Student> ban : topStudentByGradeAndClassNumber.values()) {
            for (Student s : ban.values()) {
                System.out.println(s);
            }
        }

        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
        Map<String, Set<Student.Level>> studentByScoreGroup = Stream.of(students)
                .collect(groupingBy(s -> s.getGrade() + "-" + s.getClassNumber(),
                        mapping(s -> {
                            if (s.getScore() >= 200) {
                                return Student.Level.HIGH;
                            } else if (s.getScore() >= 100) {
                                return Student.Level.MID;
                            } else {
                                return Student.Level.LOW;
                            }
                        }, toSet())
                ));

        Set<String> keySet2 = studentByScoreGroup.keySet();

        for (String key : keySet2) {
            System.out.println("[" + key + "]" + studentByScoreGroup.get(key));
        }
    }
}
