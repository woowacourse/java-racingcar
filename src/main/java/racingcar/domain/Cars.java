package racingcar.domain;/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Cars.java
 * cars 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Cars {
	public static final int MINIMUM_NUMBER_OF_ROUND = 1;

	private final List<Car> cars = new ArrayList<>();
	private final int numberOfRound;

	Cars(List<String> names, int numberOfRound) {
		if (numberOfRound < MINIMUM_NUMBER_OF_ROUND) {
			throw new IllegalArgumentException("round number must be positive");
		}

		for(String name : names) {
			cars.add(new Car(name));
		}
		this.numberOfRound = numberOfRound;
	}

}
