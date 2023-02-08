package view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {}

    public static OutputView getInstance() {
        return INSTANCE;
    }

    private void printMessage(String message) {

    }

    public void printReadCarNamesMessage() {

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
