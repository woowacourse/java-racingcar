package racingcar.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {

	private static final String SPACIAL_CHAR_REGEX = "[가-힣\\w_]*";
	private static final int MAXIMUM_NAME_SIZE = 5;
	private static final String NAME_EMPTY_ERROR_MSG = "이름이 공백일 수 없습니다.";
	private static final String NAME_MAX_SIZE_WARNING_MSG = "이름이 5자보다 클 수 없습니다.";
	private static final String NAME_SPATIAL_CHAR_WARNING_MSG = "이름에 특수문자를 입력할 수 없습니다. (단, '_' 제외)";

	private final String name;

	public Name(String name) {
		checkName(name);
		this.name = name;
	}

	private void checkName(String name) {
		checkSpace(name);
		checkNameSize(name);
		checkSpecialChar(name);
	}

	private void checkSpace(String name) {
		if (name.trim().isEmpty()) {
			throw new IllegalArgumentException(NAME_EMPTY_ERROR_MSG);
		}
	}

	private void checkNameSize(String name) {
		if (name.length() > MAXIMUM_NAME_SIZE) {
			throw new IllegalArgumentException(NAME_MAX_SIZE_WARNING_MSG);
		}
	}

	private void checkSpecialChar(String name) {
		if (!Pattern.matches(SPACIAL_CHAR_REGEX, name)) {
			throw new IllegalArgumentException(NAME_SPATIAL_CHAR_WARNING_MSG);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
