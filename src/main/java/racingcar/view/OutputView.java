package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

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

    public static void printGameResults(List<String> carNames, List<List<Integer>> gameResults) {
        System.out.println("\n실행 결과");
        gameResults.forEach(gameResult -> {
            IntStream.range(0, gameResult.size())
                    .forEach(idx -> {
                        String name = carNames.get(idx);
                        int position = gameResult.get(idx);
                        System.out.println(name + " : " + "-".repeat(position));
                    });
            System.out.println();
        });
    }
}
