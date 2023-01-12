package ch05.스트림실전연습;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리
        List<Transaction> transaction2011 = transactions.stream()
                .filter(tr -> tr.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println("2011년 거래(오름차순)");
        for (Transaction transaction : transaction2011) {
            System.out.println(transaction);
        }

        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> cities = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        /*
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
         */

        System.out.println("거래자가 근무하는 모든 도시들: " + cities);

        // 3. Cambridge 에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬
        List<Trader> tradersInCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        System.out.println("Cambridge에서 근무하는 트레이더: " + tradersInCambridge);

        // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환
        List<String> traders = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("트레이더: " + traders);

        // String 형태로 반환하는 법
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(traderStr);

        // 5. 밀라노에 거래자가 있는가?
        if (transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"))) {
            System.out.println("밀라노에 거래자가 있습니다.");
        } else {
            System.out.println("밀라노에 거래자가 없습니다.");
        }

        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
        System.out.println("케임브리지 거래자의 트랜잭션값들");
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // 7. 전채 트랜잭션 중 최댓값은 얼마인가?

        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);


        Optional<Transaction> maxTransaction = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));

        // 8. 전체 트랜잭션 중 최솟값은 얼마인가?

        Optional<Integer> min = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);

        Optional<Transaction> minTransaction = transactions.stream()
                        .min(Comparator.comparing(Transaction::getValue));

        System.out.println(max + "," + min);
        System.out.println(maxTransaction + ", " + minTransaction);

        // 거래가 없을 때 기본 문자열을 사용할 수 있도록발견된 거래가 있으면 문자열로 바꾸는 꼼수를 사용함(예, the Stream is empty)
        System.out.println(minTransaction.map(String::valueOf).orElse("No transactions found"));
    }
}
