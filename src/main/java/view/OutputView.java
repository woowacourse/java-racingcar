package view;

import domain.Cars;
import domain.RacingResults;

public class OutputView {

	public static void printRacingResults(RacingResults racingResults) {
		System.out.println(racingResults.toString());
		System.out.println();
	}

	public static void printWinners(Cars winners) {
		System.out.println(winners.toString() + "(이)가 우승했습니다.");
	}

	public static void printExceptionMsg(String msg) {
		System.out.println(msg);
	}
}
