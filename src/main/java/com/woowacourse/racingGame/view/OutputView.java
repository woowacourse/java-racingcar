package com.woowacourse.racingGame.view;

import java.util.List;

import com.woowacourse.racingGame.domain.Result;
import com.woowacourse.racingGame.utils.StringUtil;

public class OutputView {
	public void printExceptionMessage(final String exceptionMessage) {
		System.out.println(exceptionMessage);
	}

	public void printRacingGameResult(final List<Result> results) {
		for (Result result : results) {
			printSelectedResultCarStatus(result);
		}
	}

	private void printSelectedResultCarStatus(final Result result) {
		final List<String> racingCarStatus = result.getRacingCarStatus();

		for (String carStatus : racingCarStatus) {
			System.out.println(carStatus);
		}
		System.out.println("");
	}

	public void printWinners(final Result finalResult) {
		final String winners = StringUtil.joinWinningCar(finalResult.getWinners());
		System.out.println(winners + "가 최종 우승했습니다.");
	}
}
