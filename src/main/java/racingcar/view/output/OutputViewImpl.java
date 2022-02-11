package racingcar.view.output;

import static racingcar.view.output.message.OutputMessage.*;

import java.util.List;

import racingcar.utils.Delimiter;

public class OutputViewImpl implements OutputView {

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printMessageOfRequestCarNames() {
		printMessage(MessageOfRequestCarNames);
	}

	public void printMessageOfRequestRound() {
		printMessage(MessageOfRequestRound);
	}

	public void printMessageOfStatusTitle() {
		printMessage(MessageOfStatusTitle);
	}

	public void printCarStatuses(List<String> carStatuses) {
		carStatuses.forEach(this::printMessage);
	}

	public void printMessageOfWinners(List<String> winnerNames) {
		String message = String.format(MessageFormatOfPrintWinner, Delimiter.joinWithComma(winnerNames));
		printMessage(message);
	}

	public void printEmptyLine() {
		printMessage("");
	}

}
