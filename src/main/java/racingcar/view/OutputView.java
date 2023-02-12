package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PRINT_READ_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PRINT_READ_TRY_NUM_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String PRINT_RACING_RESULT_MESSAGE = "\n실행 결과";
    private static final String PRINT_WINNERS_MESSAGE = "가 최종 우승했습니다.";

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printReadCarNamesMessage() {
        printMessage(PRINT_READ_CAR_NAMES_MESSAGE);
    }

    public void printReadTryNumMessage() {
        printMessage(PRINT_READ_TRY_NUM_MESSAGE);
    }

    public void printRacingResultMessage() {
        printMessage(PRINT_RACING_RESULT_MESSAGE);
    }

    public void printCurrentRacingCarsPosition(Map<String, Integer> carPositonMap) {
        for (String carName : carPositonMap.keySet()) {
            Integer position = carPositonMap.get(carName);
            String convertPositionToDash = "-".repeat(position);
            printMessage(carName + " : " + convertPositionToDash);
        }
        printMessage("");
    }

    public void printWinners(List<String> winners) {
        printMessage(String.join(", ", winners) + PRINT_WINNERS_MESSAGE);
    }
}
