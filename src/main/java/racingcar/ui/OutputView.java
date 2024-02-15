package racingcar.ui;


import static racingcar.ui.OutputCommand.CAR_RESULT_FORMAT;
import static racingcar.ui.OutputCommand.ERROR_PREFIX;
import static racingcar.ui.OutputCommand.HYPHEN;
import static racingcar.ui.OutputCommand.RESULT_TITLE;
import static racingcar.ui.OutputCommand.WINNERS_DELIMITER;
import static racingcar.ui.OutputCommand.WINNER_FORMAT;

import racingcar.domain.Winner;

public class OutputView {
    public static void printInputErrorMessage() {
        System.out.println(ERROR_PREFIX + OutputCommand.INPUT_ERROR_MESSAGE);
    }

    public static void printCarResult(String carName, int distance) {
        System.out.printf(CAR_RESULT_FORMAT, carName, getRepeatedHyphen(distance));
    }

    private static String getRepeatedHyphen(int distance) {
        return HYPHEN.repeat(distance);
    }

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void printNewLine() {
        System.out.print("\n");
    }

    public static void printWinner(Winner winner) {
        System.out.printf(WINNER_FORMAT, String.join(WINNERS_DELIMITER, winner.getWinners()));
    }
}
