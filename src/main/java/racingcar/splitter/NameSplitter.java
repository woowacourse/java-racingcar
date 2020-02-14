package racingcar.splitter;

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
public class NameSplitter {
	private static final String DELIMITER = ",";
	private static final int MINIMUM_NUMBER_OF_NAMES = 2;
	private static final int MINIMUM_LENGTH_OF_NAME = 1;
	private static final int MAXIMUM_LENGTH_OF_NAME = 5;

	public static List<String> split(String rawNames) {
		List<String> names = Arrays.stream(rawNames.split(DELIMITER))
			.collect(Collectors.toList());
		validate(names);
		return names;
	}

	private static void validate(List<String> names) {
		validateNumberOfName(names);
		validateLengthOfName(names);
		validateDuplicatedName(names);
	}

	private static void validateNumberOfName(List<String> names) {
		if (names.size() < MINIMUM_NUMBER_OF_NAMES) {
			throw new IllegalArgumentException(RacingCarMessage.EXCEPTION_NOT_ENOUGH_CAR.getMessageText());
		}
	}

	private static void validateLengthOfName(List<String> names) {
		for (String name : names) {
			if (name.length() < MINIMUM_LENGTH_OF_NAME || name.length() > MAXIMUM_LENGTH_OF_NAME) {
				throw new IllegalArgumentException(RacingCarMessage.EXCEPTION_LENGTH_OF_NAME.getMessageText());
			}
		}
	}

	private static void validateDuplicatedName(List<String> names) {
		Set<String> tmpNameSet = new HashSet<>(names);
		if (tmpNameSet.size() != names.size()) {
			throw new IllegalArgumentException(RacingCarMessage.EXCEPTION_DUPLICATED_NAME.getMessageText());
		}
	}
}
