package racingcar.view.output;

import java.util.List;

import racingcar.utils.Delimiter;
import racingcar.view.output.message.OutputMessage;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageOfRequestCarNames() {
        printMessage(OutputMessage.MessageOfRequestCarNames);
    }

    public void printMessageOfRequestRound() {
        printMessage(OutputMessage.MessageOfRequestRound);
    }

    public void printMessageOfStatusTitle() {
        printMessage(OutputMessage.MessageOfStatusTitle);
    }

    public void printCarStatuses(List<String> carStatuses) {
        carStatuses.forEach(this::printMessage);
    }

    public void printMessageOfWinners(List<String> winnerNames) {
        String message = String.format(OutputMessage.MessageFormatOfPrintWinner, Delimiter.joinWithComma(winnerNames));
        printMessage(message);
    }

    public void printEmptyLine() {
        printMessage("");
    }

}
