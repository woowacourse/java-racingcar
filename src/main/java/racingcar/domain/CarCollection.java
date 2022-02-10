package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarCollection {

	private final List<Car> cars = new ArrayList<>();

	public CarCollection(List<String> names) {
		validateCarNames(names);
		names.forEach(name -> cars.add(new Car(name)));
	}

	private void validateCarNames(List<String> names) {
		validateNameIsTooLong(names);
		validateNameIsEmpty(names);
		validateNameIsDuplicate(names);
	}

	private void validateNameIsTooLong(List<String> names) {
		if (names.stream().anyMatch(CarNameLength::isTooLong)) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
		}
	}

	private void validateNameIsDuplicate(List<String> names) {
		if (names.stream().anyMatch(name -> Collections.frequency(names, name) > 1)) {
			throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
		}
	}

	private void validateNameIsEmpty(List<String> names) {
		if (names.stream().anyMatch(String::isEmpty)) {
			throw new IllegalArgumentException("자동차의 이름은 공백이 될 수 없습니다.");
		}
	}

}
