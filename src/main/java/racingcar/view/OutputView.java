package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_INFORMATION_DELIMITER = " : ";
    private static final String DISTANCE_COMMAND = "-";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public void printNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printCountInput() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }


    public void printRoundResult(Map<String, Integer> roundResult) {
        for (Map.Entry<String, Integer> result : roundResult.entrySet()) {
            String carName = result.getKey();
            int distance = result.getValue();
            printCarResult(carName, distance);
        }
    }

    public void printCarResult(String carName, int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carName).append(CAR_INFORMATION_DELIMITER);
        stringBuilder.append(DISTANCE_COMMAND.repeat(distance));
        System.out.println(stringBuilder.toString());
    }

    public void printWinners(List<String> winnerNames) {
        StringBuilder stringBuilder = new StringBuilder("\n");
        String str = String.join(WINNER_NAME_DELIMITER, winnerNames);
        stringBuilder.append(str).append(WINNER_MESSAGE);
        System.out.println(stringBuilder.toString());
    }


    public void printNewLine() {
        System.out.println("");
    }
}
