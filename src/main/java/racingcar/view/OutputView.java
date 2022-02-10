package racingcar.view;

import java.util.List;

import racingcar.utils.Delimiter;

public class OutputView {

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printCarStatuses(List<String> carStatuses) {
		carStatuses.forEach(this::printMessage);
	}

	public void printMessageOfRequestCarNames() {
		printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}

	public void printMessageOfRequestRound() {
		printMessage("시도할 회수는 몇회인가요?");
	}

	public void printEmptyLine() {
		printMessage("");
	}

	public void printMessageTitleOfStatus() {
		printMessage("실행 결과");
	}

	public void printMessageOfWinners(List<String> winnerNames) {
		String message = Delimiter.joinWithComma(winnerNames) + "가 최종 우승했습니다.";
		printMessage(message);
	}
}
