package racingcar.view;

import racingcar.dto.CarStatus;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String DELIMITER = " : ";
    private static final String MOVING_SYMBOL = "-";
    private static final String WINNER_DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRaceResult(List<CarStatus> raceResult) {
        raceResult.forEach(carStatus -> {
            int moveCount = carStatus.getCurrentPosition();
            System.out.println(carStatus.getName() + DELIMITER + MOVING_SYMBOL.repeat(moveCount));
        });
        System.out.println();
    }

    public static void printFinalResult(List<String> winnersName) {
        String winnersResult = String.join(WINNER_DELIMITER, winnersName);
        System.out.println(winnersResult + WINNER_MESSAGE);
    }

    public static void printError(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}
