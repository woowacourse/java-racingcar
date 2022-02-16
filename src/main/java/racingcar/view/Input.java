package racingcar.view;

import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.validation.CarValidator;
import racingcar.domain.validation.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Input {
	private static final String DELIMITER = ",";
	private static final String CAR_BLANK_ERROR_MESSAGE = "자동차 이름은 %s일 수 없습니다.";
	private static final Scanner scan = new Scanner(System.in);

	private Input(){}

	public static Cars carName() {
		try {
			Output.getCarName();
			String inputValue = scan.nextLine();
			Validator.checkBlank(inputValue, CAR_BLANK_ERROR_MESSAGE);
			String[] names = inputValue.split(DELIMITER);
			return new Cars(toCars(names));
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return carName();
		}
	}

	public static Attempt attempt() {
		try {
			Output.getAttempt();
			String inputValue = scan.nextLine();
			return new Attempt(inputValue);
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return attempt();
		}
	}

	private static List<Car> toCars(String[] names) {
		List<Car> cars = new ArrayList<>();

		for (String name : names) {
			cars.add(createCar(name));
		}
		return cars;
	}

	private static Car createCar(String name) {
		return new Car(name.trim());
	}
}
