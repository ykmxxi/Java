package ch05.ch0501;

/*
    p.195
*/
public class ArrayEx4 {

    public static void main(String[] args) {

        char[] abc = {'A', 'B', 'C', 'D'};
        char[] num = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        // char 배열은 println() 으로 배열에 저장된 모든 문자 출력 가능
        System.out.println(abc);
        System.out.println(num);

        // 배열 abc와 num을 붙여 하나의 배열로
        char[] result = new char[abc.length + num.length];
        System.arraycopy(abc, 0, result, 0, abc.length);
        System.arraycopy(num, 0, result, abc.length, num.length);
        System.out.println(result);

    }
}
