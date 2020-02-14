package racingcar.splitter;

import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.message.RacingCarMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * NameSplitter.java
 * 이름분리를 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class CarSplitter {
	private static final String DELIMITER = ",";

	private CarSplitter() {
	}

	public static List<Car> split(String rawNames) {
		return Arrays.stream(rawNames.split(DELIMITER))
			.map(Name::new)
			.map(Car::new)
			.collect(Collectors.toList());
	}
}
