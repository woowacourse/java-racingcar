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
import java.util.List;
import java.util.stream.Collectors;

public class NameSplitter {
	public static final String DELIMITER = ",";

	public static List<String> split(String names) {
		return Arrays.stream(names.split(DELIMITER))
			.collect(Collectors.toList());
	}
}
