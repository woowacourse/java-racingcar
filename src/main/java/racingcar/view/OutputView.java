package racingcar.view;

import racingcar.model.GameResult;
import racingcar.model.RoundResult;

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

    private static void printRoundResult(RoundResult roundResult) {
        List<String> names = roundResult.getNames();
        List<Integer> positions = roundResult.getPositions();

        IntStream.range(0, names.size())
                .forEach(idx -> {
                    String s = makeCarInfo(names.get(idx), positions.get(idx));
                    System.out.println(s);
                });
    }

    public static void printGameResults(GameResult gameResult) {
        System.out.println("\n실행 결과");
        gameResult.getGameResult().forEach(roundResult -> {
            printRoundResult(roundResult);
            System.out.println();
        });
    }
}
