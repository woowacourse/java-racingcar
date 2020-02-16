package com.woowacourse.racingGame.view;

import java.util.List;
import java.util.Map;

import com.woowacourse.racingGame.domain.Result;
import com.woowacourse.racingGame.utils.StringUtil;

public class OutputView {
	public void printExceptionMessage(final String exceptionMessage) {
		System.out.println(exceptionMessage);
	}

	public void printRacingGameResult(final List<Result> results) {
		for (Result result : results) {
			printRacingCarStatus(result);
		}
	}

	private void printRacingCarStatus(final Result result) {
		final Map<String, Integer> racingCarStatus = result.getRacingCarStatus();

		racingCarStatus.forEach((name, position) ->
			System.out.println(name
				+ " : "
				+ StringUtil.convertIntoDashBy(position)));
		System.out.println();
	}

	public void printWinners(final Result finalResult) {
		final String winners = StringUtil.joinNameOf(finalResult.getWinners());
		System.out.println(String.format("%s가 최종 우승했습니다.", winners));
	}
}
