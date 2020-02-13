package com.woowacourse.racingGame.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {
	private static final String DELIMITER = ",";
	private static final String POSITION_CHARACTER = "-";

	public static List<String> splitCarName(final String inputCarName) {
		return new ArrayList<>(Arrays.asList(inputCarName.split(DELIMITER))).stream()
			.map(String::trim)
			.collect(Collectors.toList());
	}

	public static String convertPositionToString(final int position) {
		return Stream.generate(() -> POSITION_CHARACTER)
			.limit(position)
			.collect(Collectors.joining());
	}

	public static String joinWinningCar(final List<String> winners) {
		return String.join(DELIMITER, winners);
	}
}
