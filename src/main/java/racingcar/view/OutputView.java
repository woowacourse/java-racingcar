package racingcar.view;

import java.util.List;
import racingcar.constants.InputConstant;
import racingcar.constants.OutputConstant;

public class OutputView {
    public static void printNameInput() {
        System.out.println(InputConstant.CAR_NAME_INPUT_MESSAGE.getMessage());
    }

    public static void printCountInput() {
        System.out.println(InputConstant.TRY_COUNT_INPUT_MESSAGE.getMessage());
    }

    public static void printResultMessage() {
        System.out.println(OutputConstant.RESULT_MESSAGE.getMessage());
    }

    public static void printRoundResult(String carName, int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carName).append(OutputConstant.CAR_INFORMATION_DELIMITER.getMessage());
        for (int i = 0; i < distance; i++) {
            stringBuilder.append(OutputConstant.DISTANCE_COMMAND.getMessage());
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printWinners(List<String> winnerNames) {
        StringBuilder stringBuilder = new StringBuilder("\n");
        String str = String.join(", ", winnerNames);
        stringBuilder.append(str).append(OutputConstant.WINNER_MESSAGE.getMessage());
        System.out.println(stringBuilder.toString());
    }
}
