package racingcar.Domain;

import java.util.Objects;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/14
 */
public class Name {
	private String name;

	public String getName() {
		return this.name;
	}

	public Name(String inputName) {
		Objects.requireNonNull(inputName, "자동차 이름은 null이 들어갈 수 없습니다.");
		validateInputName(inputName);
		this.name = inputName;
	}

	private void validateInputName(String inputName) {
		validateInputNameIsEmpty(inputName);
		validateInputNameHasBlank(inputName);
		validateInputNameLength(inputName);
	}

	private void validateInputNameIsEmpty(String inputName) {
		if (inputName.equals("")) {
			throw new IllegalArgumentException("자동차 이름이 빈문자열일 수 없습니다.");
		}
	}

	private void validateInputNameHasBlank(String inputName) {
		if (inputName.contains(" ")) {
			throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
		}
	}

	private void validateInputNameLength(String inputName) {
		if (inputName.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name) o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
