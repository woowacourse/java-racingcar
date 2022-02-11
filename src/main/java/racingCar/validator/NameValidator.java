package racingCar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class NameValidator {

	public static final String SPACIAL_CHAR_REGEX = "[가-힣\\w_]*";
	public static final int MAXIMUM_NAME_SIZE = 5;
	public static final int MINIMUM_NAME_LIST_SIZE = 1;
	public static final String INPUT_STRING_NULL_ERROR_MSG = "빈 값이 입력되었습니다.";
	public static final String NAME_EMPTY_ERROR_MSG = "이름이 공백일 수 없습니다.";
	public static final String NAME_MAX_SIZE_WARNING_MSG = "이름이 5자보다 클 수 없습니다.";
	public static final String NAME_SPATIAL_CHAR_WARNING_MSG = "이름에 특수문자를 입력할 수 없습니다. (단, '-' 제외)";
	public static final String CAR_NUMBER_IS_ONE_WARNING_MSG = "경주할 자동차가 한 대일 경우 경주를 진행할 수 없습니다.";
	public static final String NAME_DUPLICATION_WARNING_MSG = "중복되는 이름이 존재합니다.";

	public static void checkCarName(String name) throws Exception {
		checkSpace(name);
		checkNameSize(name);
		checkSpecialChar(name);
	}

	public static void checkNameList(List<String> nameList) throws Exception {
		checkOneName(nameList);
		checkDuplicatedName(nameList);
	}

	public static void checkNull(String inputString) throws Exception {
		if (inputString == null || inputString.isEmpty()) {
			throw new Exception(INPUT_STRING_NULL_ERROR_MSG);
		}
	}

	public static void checkSpace(String name) throws Exception {
		if (name.trim().isEmpty()) {
			throw new Exception(NAME_EMPTY_ERROR_MSG);
		}
	}

	public static void checkNameSize(String name) throws Exception {
		if (name.length() > MAXIMUM_NAME_SIZE) {
			throw new Exception(NAME_MAX_SIZE_WARNING_MSG);
		}
	}

	public static void checkSpecialChar(String name) throws Exception {
		if (!Pattern.matches(SPACIAL_CHAR_REGEX, name)) {
			throw new Exception(NAME_SPATIAL_CHAR_WARNING_MSG);
		}
	}

	public static void checkOneName(List<String> nameList) throws Exception {
		if (nameList.size() <= MINIMUM_NAME_LIST_SIZE) {
			throw new Exception(CAR_NUMBER_IS_ONE_WARNING_MSG);
		}
	}

	public static void checkDuplicatedName(List<String> nameList) throws Exception {
		Set<String> nameSet = new HashSet<>(nameList);
		if (nameSet.size() != nameList.size()) {
			throw new Exception(NAME_DUPLICATION_WARNING_MSG);
		}
	}
}
