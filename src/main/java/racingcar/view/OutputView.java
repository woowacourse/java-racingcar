package racingcar.view;

import java.util.List;

public class OutputView {
	public void printResultSentence() {
		System.out.println("\n실행 결과");
	}

	public void printResult(List<String> results) {
		results.stream()
			.forEach(System.out::println);
		System.out.println();
	}

	public void printWinners(List<String> winners) {
		System.out.print(String.join(", ", winners));
		System.out.println("가 최종 우승했습니다.");
	}
}
