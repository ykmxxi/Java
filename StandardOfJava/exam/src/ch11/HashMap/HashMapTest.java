package ch11.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> member = new HashMap<>();
        member.put("Kim", "1234");
        member.put("Park", "1111");
        member.put("Park", "1234");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ID 와 PW를 입력하세요.");
            System.out.print("ID: ");
            String id = scanner.nextLine().trim();

            System.out.print("PW: ");
            String pw = scanner.nextLine().trim();

            if (!member.containsKey(id)) {
                System.out.println("입력한 ID가 존재하지 않습니다. 다시 입력하세요.");
                continue;
            }

            if (!(member.get(id)).equals(pw)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
            }

            if ((member.get(id)).equals(pw)) {
                System.out.println("로그인 성공");
                break;
            }
        }
    }
}
