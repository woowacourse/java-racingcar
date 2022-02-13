package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String ROUND_RESULT_TEXT = "실행 결과";
    private static final String CAR_INFO_DELIMITER = " : ";
    private static final String DISTANCE_SYMBOL = "-";
    private static final String WINNERS_JOINER_DELIMITER = ", ";
    private static final String ANNOUNCE_GAME_WINNER_TEXT = "가 최종 우승했습니다.";

    public static void printRoundResultText() {
        printBlankLine();
        print(ROUND_RESULT_TEXT);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCurrentCarPosition(car);
        }
        printBlankLine();
    }

    public static void printCurrentCarPosition(Car car) {
        String carPositionMessage = car.getName()
            + CAR_INFO_DELIMITER
            + DISTANCE_SYMBOL.repeat(car.getPosition());

        print(carPositionMessage);
    }

    public static void printWinners(List<Car> winners) {
        StringJoiner winnerNames = new StringJoiner(WINNERS_JOINER_DELIMITER);

        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        print(winnerNames + ANNOUNCE_GAME_WINNER_TEXT);
    }

    private static void print(String string) {
        System.out.println(string);
    }

    private static void printBlankLine() {
        System.out.println();
    }
}
