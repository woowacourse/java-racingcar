package racingcar.view.output;

import java.util.List;

import racingcar.dto.CarStatusDto;
import racingcar.utils.Delimiter;

public class OutputView {

    public void printMessage(final String message) {
        System.out.println(message);
    }

    private void printMessage(final OutputMessage outputMessage) {
        this.printMessage(outputMessage.getMessage());
    }

    public void printMessageOfRequestCarNames() {
        printMessage(OutputMessage.REQUEST_CAR_NAMES_MESSAGE);
    }

    public void printMessageOfRequestRound() {
        printMessage(OutputMessage.REQUEST_ROUND_MESSAGE);
    }

    public void printMessageOfStatusTitle() {
        printEmptyLine();
        printMessage(OutputMessage.PRINT_TITLE_OF_STATUS);
    }

    public void printCarStatuses(final List<CarStatusDto> carStatuses) {
        carStatuses.stream()
                .map(CarStatusDto::toString)
                .forEach(this::printMessage);
        printEmptyLine();
    }

    public void printMessageOfWinners(final List<String> winnerNames) {
        final String message = String.format(
                OutputMessage.PRINT_WINNERS.getMessage(), Delimiter.joinWithComma(winnerNames));
        printMessage(message);
    }

    public void printEmptyLine() {
        printMessage(OutputMessage.EMPTY_STRING);
    }

}
