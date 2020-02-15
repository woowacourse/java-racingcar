package com.woowacourse.racingGame.domain;

import java.util.stream.Collectors;

import com.woowacourse.racingGame.utils.StringUtil;

public class CarsFactory {
	public static Cars generate(final String inputCarName) {
		return new Cars(StringUtil.split(inputCarName).stream()
			.map(Name::new)
			.map(Car::new)
			.collect(Collectors.toList()));
	}
}
