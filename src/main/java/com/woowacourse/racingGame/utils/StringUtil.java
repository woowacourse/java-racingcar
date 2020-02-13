package com.woowacourse.racingGame.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.woowacourse.racingGame.domain.Car;

public class StringUtil {
	private static final String DELIMITER = ",";
	private static final String POSITION_CHARACTER = "-";
	public static final String JOIN_DELIMITER = ", ";

	public static List<String> splitCarName(final String inputCarName) {
		return new ArrayList<>(Arrays.asList(inputCarName.split(DELIMITER))).stream()
			.map(String::trim)
			.collect(Collectors.toList());
	}

	public static String convertCarStatus(final Car car) {
		String carPosition = Stream.generate(() -> POSITION_CHARACTER)
			.limit(car.getPosition())
			.collect(Collectors.joining());
		return car.getName()
			+ " : "
			+ carPosition;
	}

	public static String joinWinningCar(final List<String> winners) {
		return String.join(JOIN_DELIMITER, winners);
	}
}
