package com.woowacourse.racingGame.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.woowacourse.racingGame.domain.Car;
import com.woowacourse.racingGame.domain.Cars;
import com.woowacourse.racingGame.domain.Name;

public class CarsFactory {
	public static Cars generate(final String inputCarName) {
		final List<String> carNames = StringUtil.splitCarName(inputCarName);

		return new Cars(carNames.stream()
			.map(Name::new)
			.map(Car::new)
			.collect(Collectors.toList()));
	}
}
