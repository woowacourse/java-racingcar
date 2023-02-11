package racingcar.view;

import racingcar.dto.CarStatusResponse;
import racingcar.dto.GameResultResponse;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = System.lineSeparator() + "실행결과";
    private static final String GAME_RESULT_MESSAGE = "가 최종 우승했습니다.";
    private static final String PATH = "-";
    private static final String RESULT_SEPARATOR = " : ";
    private static final String RESULT_NAME_DELIMITER = ", ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(List<CarStatusResponse> carNameAndPositions) {
        StringBuilder resultBuilder = new StringBuilder();
        for (CarStatusResponse carNameAndPosition : carNameAndPositions) {
            resultBuilder.append(carNameAndPosition.getCarName())
                    .append(RESULT_SEPARATOR)
                    .append(PATH.repeat(carNameAndPosition.getCarPosition()))
                    .append(System.lineSeparator());
        }
        System.out.println(resultBuilder);
    }

    public void printEndGameResult(GameResultResponse gameResult) {
        String winnerNames = String.join(RESULT_NAME_DELIMITER, gameResult.getWinnerNames());
        System.out.println(winnerNames + GAME_RESULT_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
