package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    public static void printRequestCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printRequestTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    private static String makeCarInfo(String name, int position) {
        return name + " : " + "-".repeat(position);
    }

    private static void printRoundResult(List<String> carNames, List<Integer> roundResult) {
        IntStream.range(0, carNames.size())
                .forEach(idx -> {
                    String s = makeCarInfo(carNames.get(idx), roundResult.get(idx));
                    System.out.println(s);
                });
    }

    public static void printGameResults(List<String> carNames, List<List<Integer>> gameResult) {
        System.out.println("\n실행 결과");
        gameResult.forEach(roundResult -> {
            printRoundResult(carNames, roundResult);
            System.out.println();
        });
    }
}
