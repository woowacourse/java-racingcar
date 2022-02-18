package racingcar.view;

import static racingcar.constants.output.ResultOutputMessages.RESULT_GAME_WINNER_TEXT;
import static racingcar.constants.output.ResultOutputMessages.RESULT_ROUND_TEXT;
import static racingcar.constants.output.SymbolOutputMessages.SYMBOL_CAR_INFO_DELIMITER;
import static racingcar.constants.output.SymbolOutputMessages.SYMBOL_DISTANCE;
import static racingcar.constants.output.SymbolOutputMessages.SYMBOL_EMPTY_LINE;
import static racingcar.constants.output.SymbolOutputMessages.SYMBOL_WINNERS_JOINER_DELIMITER;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.Car;

public class OutputView {

    private OutputView() {
        throw new AssertionError();
    }

    public static void printRoundResultText() {
        print(RESULT_ROUND_TEXT);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarNameCurrentPosition(car);
        }
        print(SYMBOL_EMPTY_LINE);
    }

    public static void printCarNameCurrentPosition(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(car.getName()).append(SYMBOL_CAR_INFO_DELIMITER);

        int i = 0;
        while (!car.isSamePosition(i)) {
            sb.append(SYMBOL_DISTANCE);
            i++;
        }

        print(sb.toString());
    }

    public static void printWinners(List<Car> winners) {
        StringJoiner joiner = new StringJoiner(SYMBOL_WINNERS_JOINER_DELIMITER);

        for (Car winner : winners) {
            joiner.add(winner.getName());
        }

        String winnerNames = joiner.toString();
        print(winnerNames + RESULT_GAME_WINNER_TEXT);
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
