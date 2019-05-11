package racingcar.validator;

import racingcar.domain.RacingGame;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarValidator {
	public static void checkAccuracyOfCarNames(List<String> inputs) {
		if (isSmallNumOfCars(inputs)) {
			throw new IllegalArgumentException("자동차 게임을 위한 차의 이름을 "
					+ RacingGame.MIN_NUM_OF_CARS_FOR_GAME + "개 이상 입력해주세요.");
		}
		if (isDuplicate(inputs)) {
			throw new IllegalArgumentException("서로 다른 이름을 입력해주세요.");
		}
	}

	private static boolean isSmallNumOfCars(List<String> inputs) {
		return (inputs.size() < RacingGame.MIN_NUM_OF_CARS_FOR_GAME);
	}

	private static boolean isDuplicate(List<String> inputs) {
		Set<String> set = inputs.stream()
				.collect(Collectors.toSet());

		return (inputs.size() != set.size());
	}
}
