package racingcargame.domain;

import java.util.Objects;

import racingcargame.exception.CarNameInputException;
import racingcargame.view.OutputView;

public class Name {
	private static final int MAX_NAME_LENGTH = 5;

	private String name;

	public Name(String name) {
		validate(name);
		this.name = name.trim();
	}

	private void validate(String name) {
		checkNullInput(name);
		name = name.trim();
		checkOverMaxNameLength(name);
		checkBlankInput(name);
	}

	private void checkNullInput(String name) {
		if (name == null) {
			throw new CarNameInputException("※자동차 이름으로 Null값이 들어옴");
		}
	}

	private void checkOverMaxNameLength(String name) {
		if (MAX_NAME_LENGTH < name.length()) {
			OutputView.printTooLongNameErrorMessage();
			throw new CarNameInputException("※허용된 길이(5자)를 초과하는 자동차 이름이 존재");
		}
	}

	private void checkBlankInput(String name) {
		if (name.isEmpty()) {
			OutputView.printBlankInputErrorMessage();
			throw new CarNameInputException("※이름이 없는 자동차가 존재");
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
		return name.equals(name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
