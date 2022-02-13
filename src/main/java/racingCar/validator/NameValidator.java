package racingCar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

import racingCar.utlis.Constants;

public class NameValidator {
	public static final int maxNameSize = 5;

	public static void validateInput(String inputString) throws Exception {
		checkNull(inputString);
	}

	public static void validateName(String name) throws Exception {
		checkSpace(name);
		checkNameSize(name);
		checkSpecialChar(name);
	}

	public static void validateNameList(List<String> nameList) throws Exception {
		checkOneName(nameList);
		checkDuplicatedName(nameList);
	}

	private static void checkNull(String inputString) throws Exception {
		if (inputString == null || inputString.isEmpty())
			throw new Exception(Constants.EXCEPTION_NULL_MESSAGE);
	}

	private static void checkSpace(String name) throws Exception {
		if (name.trim().isEmpty()) {
			throw new Exception(Constants.EXCEPTION_SPACE_MESSAGE);
		}
	}

	private static void checkNameSize(String name) throws Exception {
		if (name.length() > maxNameSize) {
			throw new Exception(Constants.EXCEPTION_NAME_RANGE);
		}
	}

	private static void checkSpecialChar(String name) throws Exception {
		if (!Pattern.matches(Constants.NOT_SPECIAL_REGEX, name)) {
			throw new Exception(Constants.EXCEPTION_SPACIAL_MESSAGE);
		}
	}

	private static void checkOneName(List<String> nameList) throws Exception {
		if (nameList.size() <= 1) {
			throw new Exception(Constants.EXCEPTION_ONE_NAME_MESSAGE);
		}
	}

	private static void checkDuplicatedName(List<String> nameList) throws Exception {
		if (new HashSet<>(nameList).size() != nameList.size()) {
			throw new Exception(Constants.EXCEPTION_DUPLICATED_NAME_MESSAGE);
		}
	}
}
