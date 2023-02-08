package view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private static final String PRINT_READ_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private OutputView() {}

    public static OutputView getInstance() {
        return INSTANCE;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printReadCarNamesMessage() {
        printMessage(PRINT_READ_CAR_NAMES_MESSAGE);
    }

    public void printReadTryNumMessage() {

    }

    public void printRacingResultMessage(){

    }

    public void printCurrentRacingCarsPosition(Map<String, Integer> carPositonMap) {

    }

    public void printWinners(List<String> winners) {

    }


}
