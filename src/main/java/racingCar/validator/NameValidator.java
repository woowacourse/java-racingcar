package racingCar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class NameValidator {
	public static final String ERROR = "ERROR";

	public static void checkCarName(String name) throws Exception {
		checkSpace(name);
		checkNameSize(name);
		checkSpecialChar(name);
	}

	public static void checkNull(String inputString) throws Exception {
		if (inputString == null || inputString.isEmpty())
			throw new Exception(ERROR);
	}

	public static void checkSpace(String name) throws Exception {
		if (name.trim().isEmpty()) {
			throw new Exception(ERROR);
		}
	}

	public static void checkNameSize(String name) throws Exception {
		if (name.length() > 5) {
			throw new Exception(ERROR);
		}
	}

	public static void checkSpecialChar(String name) throws Exception {
		if (!Pattern.matches("[가-힣\\w_]*", name)) {
			throw new Exception(ERROR);
		}
	}

	public static void checkOneName(List<String> nameList) throws Exception {
		if (nameList.size() <= 1) {
			throw new Exception(ERROR);
		}
	}

	public static void checkDuplicatedName(List<String> nameList) throws Exception {
		Set<String> nameSet = new HashSet<>(nameList);
		if (nameSet.size() != nameList.size()) {
			throw new Exception(ERROR);
		}
	}
}
