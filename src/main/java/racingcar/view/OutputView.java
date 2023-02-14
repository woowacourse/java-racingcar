package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String RESULT_MESSAGE = System.lineSeparator() + "실행결과";
    private static final String GAME_RESULT_MESSAGE = "가 최종 우승했습니다.";
    private static final String PATH = "-";
    private static final String RESULT_SEPARATOR = " : ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(Map<String, Integer> carsState) {
        StringBuilder resultBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> carState : carsState.entrySet()) {
            int carPosition = carState.getValue();
            resultBuilder.append(carState.getKey())
                    .append(RESULT_SEPARATOR)
                    .append(PATH.repeat(carPosition))
                    .append(System.lineSeparator());
        }
        System.out.println(resultBuilder);
    }

    public void printEndGameResult(List<String> gameResult) {
        String winnerNames = String.join(", ", gameResult);
        System.out.println(winnerNames + GAME_RESULT_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
