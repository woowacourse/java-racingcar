package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Winner.java
 * winner 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        13 Feb 2020
 *
 */
public class Winner {
	private final List<Car> winners;

	public Winner(List<Car> winners) {
		this.winners = Collections.unmodifiableList(winners);
	}

	public List<String> getWinnerNames() {
		List<String> result = winners.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
		return Collections.unmodifiableList(result);
	}
}
