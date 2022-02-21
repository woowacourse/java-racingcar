package racingcar.view;

import racingcar.model.Cars;
import racingcar.model.GameResult;

import java.util.List;
import java.util.Map.Entry;

public class OutputView {

    private static final String SPLIT_DELIMITER = ",";
    private static final String RESULT_PREFIX = "실행결과";
    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";
    private static final String SEPARATOR = ":";
    private static final String MOVE_SIGN = "-";

    public static void printResultPrefix() {
        System.out.println(RESULT_PREFIX);
    }

    public static void printResult(List<GameResult> gameResults) {
        System.out.println();
        for (GameResult gameResult : gameResults) {
            printRoundResult(gameResult);
        }
    }

    public static void printRoundResult(GameResult gameResult) {
        for (Entry<String, Integer> entrySet : gameResult.getPositionByName().entrySet()) {
            System.out.println(entrySet.getKey() + SEPARATOR + MOVE_SIGN.repeat(entrySet.getValue()));
        }
        System.out.println();
    }

    public static void printWinner(Cars cars) {
        System.out.print(String.join(SPLIT_DELIMITER, cars.getWinner()));
        System.out.println(WINNER_SUFFIX);
    }
}
