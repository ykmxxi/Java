package ch06;

public class VariableArgumentsEx {

    static String concatenate(String delim, String... args) {

        String result = "";

        for (String str : args) {
            result += str + delim;
        }

        return result;
    }

    /*

    * 가변인자를 사용한 메서드는 오버로딩하지 않는 것이 좋다
        - 두 오버로딩된 메서드가 구분되지 않아서 컴파일에러가 발생하기 쉽다.

    static String concatenate(String... args) {

        return concatenate("", args);
    }

     */


    public static void main(String[] args) {

        String[] stringArr = {"100", "200", "300"};

        System.out.println(concatenate("", "100", "200", "300"));
        System.out.println(concatenate("-", stringArr));
        System.out.println(concatenate(" , ", new String[]{"1", "2", "3"}));


    }
}
