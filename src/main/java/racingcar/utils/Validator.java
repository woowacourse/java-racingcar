package racingcar.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {
	private static final int maxLengthOfName = 5;

	public static boolean isValidLengthOfName(String name) {
		return name.length() <= maxLengthOfName;
	}

	public static boolean containDuplicatedName(String[] names) {
		Set<String> nameSet = new HashSet<>(Arrays.asList(names));
		return nameSet.size() != names.length;
	}
}
