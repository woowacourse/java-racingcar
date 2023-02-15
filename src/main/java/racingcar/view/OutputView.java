package racingcar.view;

import racingcar.dto.CarStatus;

import java.util.List;

public class OutputView {
    private static final String DELIMITER = " : ";
    private static final String MOVING_SYMBOL = "-";
    private static final String WINNER_DELIMITER = ", ";

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCarStatus(List<CarStatus> carStatuses) {
        carStatuses.forEach(carStatus -> {
            int moveCount = carStatus.getCurrentPosition();
            System.out.println(carStatus.getName() + DELIMITER + MOVING_SYMBOL.repeat(moveCount));
        });

        System.out.println();
    }

    public static void printFinalResult(List<String> winnersName) {
        String winnersResult = String.join(WINNER_DELIMITER, winnersName);
        System.out.println(winnersResult + "가 최종 우승했습니다.");
    }
}
