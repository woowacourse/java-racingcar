package racingcar.view.output;

import java.util.List;

import racingcar.utils.Delimiter;
import racingcar.view.output.message.OutputMessage;

public class OutputView {

    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void printMessageOfRequestCarNames() {
        printMessage(OutputMessage.MESSAGE_OF_REQUEST_CAR_NAMES);
    }

    public void printMessageOfRequestRound() {
        printMessage(OutputMessage.MESSAGE_OF_REQUEST_ROUND);
    }

    public void printMessageOfStatusTitle() {
        printEmptyLine();
        printMessage(OutputMessage.MESSAGE_OF_STATUS_TITLE);
    }

    public void printCarStatuses(final List<String> carStatuses) {
        carStatuses.forEach(this::printMessage);
        printEmptyLine();
    }

    public void printMessageOfWinners(final List<String> winnerNames) {
        final String message = String.format(
                OutputMessage.MESSAGE_FORMAT_OF_PRINT_WINNERS, Delimiter.joinWithComma(winnerNames));
        printMessage(message);
    }

    public void printEmptyLine() {
        printMessage(OutputMessage.EMPTY_STRING);
    }

}
