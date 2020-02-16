package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * CarsFactory.java
 * 자동차 일급 컬렉션 생성하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class CarsFactory {
	private static final String SPLIT_DELIMITER = ",";

	private CarsFactory() {
	}

	public static Cars createCars(String rawNames) {
		return new Cars(split(rawNames));
	}

	private static List<Car> split(String rawNames) {
		return Arrays.stream(rawNames.split(SPLIT_DELIMITER))
			.map(Name::new)
			.map(Car::new)
			.collect(Collectors.toList());
	}
}
