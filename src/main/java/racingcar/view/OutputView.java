package racingcar.view;

import racingcar.domain.RacingResult;
import racingcar.domain.Winner;

public class OutputView {
	public static void printRacingResult(RacingResult racingResult) {
		System.out.println("실행 결과");
		System.out.println(racingResult);
	}

	public static void printWinners(Winner winner) {
		System.out.println(String.join(",", winner.getWinner()) + "가 우승했습니다.");
	}
}
