package racingcar.splitter;/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * ***.java
 * 000 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NameSplitter {
	public static final String DELIMITER = ",";
	public static final int MINIMUM_NUMBER_OF_NAMES = 2;
	public static final int MINIMUM_LENGTH_OF_NAME = 1;
	public static final int MAXIMUM_LENGTH_OF_NAME = 5;

	public static List<String> split(String nameValue) {
		List<String> names = Arrays.stream(nameValue.split(DELIMITER))
			.collect(Collectors.toList());
		if (names.size() < MINIMUM_NUMBER_OF_NAMES) {
			throw new IllegalArgumentException("car must be at least one");
		}
		for (String name : names) {
			if (name.length() < MINIMUM_LENGTH_OF_NAME || name.length() > MAXIMUM_LENGTH_OF_NAME) {
				throw new IllegalArgumentException("name must be between 1-5");
			}
		}
		Set<String> tmpNameSet = new HashSet<>(names);
		if (tmpNameSet.size() != names.size()) {
			throw new IllegalArgumentException("name can not be duplicated");
		}
		return names;
	}
}
