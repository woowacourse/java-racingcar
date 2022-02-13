package racingcar.view.output;

import java.util.List;

public interface OutputView {

    void printMessage(String message);

    void printMessageOfRequestCarNames();

    void printMessageOfRequestRound();

    void printMessageOfStatusTitle();

    void printCarStatuses(List<String> carStatuses);

    void printMessageOfWinners(List<String> winnerNames);

    void printEmptyLine();

}
