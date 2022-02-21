package racingcar.domain;

import java.util.Objects;

import racingcar.util.Constant;

public class CarName {
	private final String name;

	public CarName(String name) {
		carValid(name);
		this.name = name;
	}

	private void carValid(String name) {
		checkBlank(name, Constant.CAR_BLANK_ERROR_MESSAGE);
		validLength(name);
	}

	private void checkBlank(String name, String text) {
		if (name == null) {
			throw new IllegalArgumentException(String.format(text, Constant.NULL_ERROR));
		}
		if (name.trim().equals(Constant.EMPTY)) {
			throw new IllegalArgumentException(String.format(text, Constant.EMPTY_ERROR));
		}
	}

	private void validLength(String name) {
		if (!(name.trim().length() <= Constant.CAR_LENGTH_LIMIT)) {
			throw new IllegalArgumentException(Constant.CAR_NAME_LENGTH_ERROR_MESSAGE);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "CarName{" +
			"name='" + name + '\'' +
			'}';
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof CarName) {
			CarName carName = (CarName)object;
			return carName.name.equals(name);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
