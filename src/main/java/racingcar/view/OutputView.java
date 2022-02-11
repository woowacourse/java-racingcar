package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.StringJoiner;

import static racingcar.constants.OutputMessages.ANNOUNCE_GAME_WINNER_TEXT;
import static racingcar.constants.OutputMessages.CAR_INFO_DELIMITER;
import static racingcar.constants.OutputMessages.DISTANCE_SYMBOL;
import static racingcar.constants.OutputMessages.EMPTY_LINE;
import static racingcar.constants.OutputMessages.ROUND_RESULT_TEXT;
import static racingcar.constants.OutputMessages.WINNERS_JOINER_DELIMITER;
import static racingcar.constants.SystemConstants.ZERO;

public class OutputView {

    public static void printRoundResultText() {
        print(ROUND_RESULT_TEXT);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarNameCurrentPosition(car);
        }
        print(EMPTY_LINE);
    }

    public static void printCarNameCurrentPosition(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(car.getName()).append(CAR_INFO_DELIMITER);

        for (int i = ZERO; i < car.getPosition(); i++) {
            sb.append(DISTANCE_SYMBOL);
        }

        print(sb.toString());
    }

    public static void printWinners(List<Car> winners) {
        StringJoiner joiner = new StringJoiner(WINNERS_JOINER_DELIMITER);

        for (Car winner : winners) {
            joiner.add(winner.getName());
        }

        String winnerNames = joiner.toString();
        print(winnerNames + ANNOUNCE_GAME_WINNER_TEXT);
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
