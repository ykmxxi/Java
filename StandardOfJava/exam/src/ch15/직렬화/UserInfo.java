package ch15.직렬화;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private final String name;
    private final String password;
    private final int age;

    public UserInfo() {
        this("Unknown", "0000", 1);
    }

    public UserInfo(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
