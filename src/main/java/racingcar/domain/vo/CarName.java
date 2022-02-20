package racingcar.domain.vo;

import static racingcar.validator.CarNameValidator.*;

import java.util.Objects;

public class CarName {

	private final String name;

	public CarName(final String name) {
		validateCarName(name);
		this.name = name;
	}

	public String get() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarName carName = (CarName)o;
		return Objects.equals(name, carName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
