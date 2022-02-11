package racingCar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class NameValidator {

	public static final String EXCEPTION_NULL_MESSAGE = "빈 문자열이 입력되었습니다.";
	public static final String EXCEPTION_SPACE_MESSAGE = "이름이 space 로 이뤄져 있습니다";
	public static final String EXCEPTION_NAME_RANGE = "이름은 5자 이하만 가능합니다.";
	public static final String EXCEPTION_SPACIAL_MESSAGE = "이름에는 특수문자가 입력될 수 없습니다.";
	public static final String EXCEPTION_ONE_NAME_MESSAGE = "이름을 2개 이상 입력해주세요.";
	public static final String EXCEPTION_DUPLICATED_NAME_MESSAGE = "중복된 이름이 입력되었습니다.";

	public static void checkNameInput(String inputString) throws Exception {
		checkNull(inputString);
	}

	public static void checkName(String name) throws Exception {
		checkSpace(name);
		checkNameSize(name);
		checkSpecialChar(name);
	}

	public static void checkNameList(List<String> nameList) throws Exception {
		checkOneName(nameList);
		checkDuplicatedName(nameList);
	}

	public static void checkNull(String inputString) throws Exception {
		if (inputString == null || inputString.isEmpty())
			throw new Exception(EXCEPTION_NULL_MESSAGE);
	}

	public static void checkSpace(String name) throws Exception {
		if (name.trim().isEmpty()) {
			throw new Exception(EXCEPTION_SPACE_MESSAGE);
		}
	}

	public static void checkNameSize(String name) throws Exception {
		if (name.length() > 5) {
			throw new Exception(EXCEPTION_NAME_RANGE);
		}
	}

	public static void checkSpecialChar(String name) throws Exception {
		if (!Pattern.matches("[가-힣\\w_]*", name)) {
			throw new Exception(EXCEPTION_SPACIAL_MESSAGE);
		}
	}

	public static void checkOneName(List<String> nameList) throws Exception {
		if (nameList.size() <= 1) {
			throw new Exception(EXCEPTION_ONE_NAME_MESSAGE);
		}
	}

	public static void checkDuplicatedName(List<String> nameList) throws Exception {
		Set<String> nameSet = new HashSet<>(nameList);
		if (nameSet.size() != nameList.size()) {
			throw new Exception(EXCEPTION_DUPLICATED_NAME_MESSAGE);
		}
	}
}
