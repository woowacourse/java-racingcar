package view;

import java.util.ArrayList;
import java.util.List;

import domain.Car;

public class InputValidation {
	private static final String ERROR_NAME = "두 대 이상의 자동차 이름을 입력해주세요";
	private static final String COMMA = ",";
	private static final String ERROR_DUPLICATION = "중복되지 않은 자동차를 입력해주세요";

	List<Car> cars = new ArrayList<>();

	public List<Car> returnList(String input) {
		validateNotNull(input);
		validateHasComma(input);
		addCar(input);
		return cars;
	}

	private void validateNotNull(String input) {
		if (!input.contains(COMMA)) {
			throw new IllegalArgumentException(ERROR_NAME);
		}
	}

	private void validateHasComma(String input) {
		if (input == null || "".equals(input)) {
			throw new IllegalArgumentException(ERROR_NAME);
		}
	}

	private void addCar(String input) {
		String[] splitInputs = input.split(COMMA);
		for (String splitInput : splitInputs) {
			validateDuplication(splitInput);
			cars.add(new Car(splitInput));
		}
	}

	private void validateDuplication(String splitInput) {
		for (Car car : cars) {
			if (car.getCarName().equals(splitInput)) {
				throw new IllegalArgumentException(ERROR_DUPLICATION);
			}
		}
	}
}
