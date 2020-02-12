package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/*
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
public class Cars {
	private final List<Car> cars = new ArrayList<>();

	Cars(List<String> names) {
		for (String name : names) {
			cars.add(new Car(name));
		}
	}
}
