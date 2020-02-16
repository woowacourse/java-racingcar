package racinggame.domain;

import racinggame.domain.Car;
import racinggame.view.OutputView;

import java.util.*;

public class Output {
    private static final String LOG_DELIMITER = " : ";
    private static final String POSITION_CHARACTER = "-";
    private static final String SPLIT_DELIMITER = ",";

    private Winners winners;

    public Output(Winners winners) {
        this.winners = winners;
    }

    public String makeCarLog(String name, int position) {
        StringBuilder carLog = new StringBuilder(name);
        carLog.append(LOG_DELIMITER);
        for (int i = 0; i < position; i++) {
            carLog.append(POSITION_CHARACTER);
        }
        return carLog.toString();
    }

    public void makeWinnersLog() {
        List<String> names = winners.makeWinnerNames();
        String splitNames = String.join(SPLIT_DELIMITER, names);
        OutputView.printWinners(splitNames);
    }

    public boolean hasWinnersName(String name) {
        return winners.makeWinnerNames().contains(name);
    }
}
