package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Car;
import domain.Cars;
import domain.Trial;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String ERROR_NAME = "두 대 이상의 자동차 이름을 입력해주세요";
	private static final String COMMA = ",";
	private static final String ERROR_DUPLICATION = "중복되지 않은 자동차를 입력해주세요";

	private final List<Car> cars = new ArrayList<>();

	public Cars askCars() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		try {
			String input = scanner.nextLine();
			return new Cars(returnList(input));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askCars();
		}
	}

	public Trial askTrial() {
		System.out.println("시도할 횟수는 몇회인가요?");
		try {
			Trial trial = new Trial(Integer.parseInt(scanner.nextLine()));
			scanner.close();
			return trial;
		} catch (NumberFormatException e) {
			System.out.println("입력값은 숫자만 가능합니다.");
			return askTrial();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askTrial();
		}
	}

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
