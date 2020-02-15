package com.woowacourse.racingGame.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// NOTE : 이건 View에 필요한 작업 처리의 보조? View와 같이 있어야하지 않을까?
public class StringUtil {
	private static final String DELIMITER = ",";
	private static final String DASH = "-";
	public static final String JOIN_DELIMITER = ", ";

	public static List<String> split(final String inputCarName) {
		return Arrays.stream(inputCarName.split(DELIMITER))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	public static String convertIntoDashBy(final int position) {
		return Stream.generate(() -> DASH)
			.limit(position)
			.collect(Collectors.joining());
	}

	public static String joinNameOf(final List<String> winners) {
		return String.join(JOIN_DELIMITER, winners);
	}
}
