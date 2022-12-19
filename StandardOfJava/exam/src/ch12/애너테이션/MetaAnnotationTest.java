package ch12.애너테이션;

import java.lang.annotation.Repeatable;

@Repeatable(ToDos.class)
@interface ToDo {
    String value();
}

@interface ToDos {
    ToDo[] value();
}

@ToDo("First")
@ToDo("Second")
@ToDo("Third")

public class MetaAnnotationTest {
}
