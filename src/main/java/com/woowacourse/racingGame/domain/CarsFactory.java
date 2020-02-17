package com.woowacourse.racingGame.domain;

import java.util.stream.Collectors;

import com.woowacourse.racingGame.utils.StringUtil;

public class CarsFactory {
	public static Cars generate(final String inputCarName, MovableStrategy movableStrategy) {
		return new Cars(StringUtil.split(inputCarName).stream()
			.map(Name::new)
			.map(name -> new Car(name, movableStrategy))
			.collect(Collectors.toList()));
	}
}
