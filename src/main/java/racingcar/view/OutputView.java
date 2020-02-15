package racingcar.view;

import racingcar.domain.result.RacingResult;

public class OutputView {
    public static void printResult(RacingResult racingResult) {
        printValue(racingResult.getResult());
    }

    public static void printWinners() {

    }

    public static void printValue(String value) {
        System.out.println(value);
    }
}
