package com.woowacourse.racingGame.utils;

import java.util.stream.Collectors;

import com.woowacourse.racingGame.domain.Car;
import com.woowacourse.racingGame.domain.Cars;
import com.woowacourse.racingGame.domain.Name;

public class CarsFactory {
	public static Cars generate(final String inputCarName) {
		return new Cars(StringUtil.split(inputCarName).stream()
			.map(Name::new)
			.map(Car::new)
			.collect(Collectors.toList()));
	}
}
