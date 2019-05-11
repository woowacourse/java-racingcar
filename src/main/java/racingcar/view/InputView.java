package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.GameCount;
import racingcar.validator.CarValidator;
import racingcar.validator.GameCountValidator;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
	private static final String DELIMITER = ",";
	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {
	}

	public static List<Car> getCars() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return getCars(takeUserInput());
	}

	public static List<Car> getCars(String input) {
		try {
			return makeCars(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getCars();
		}
	}

	private static List<Car> makeCars(String input) {
		List<String> inputs = splitWithComma(input);
		CarValidator.checkAccuracyOfCarNames(inputs);
		return inputs.stream()
				.map(Car::new)
				.collect(Collectors.toList());
	}

	private static List<String> splitWithComma(String input) {
		return Stream.of(input.split(DELIMITER))
				.map(String::trim)
				.collect(Collectors.toList());
	}

	public static GameCount getGameCount() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		return getGameCount(takeUserInput());
	}

	public static GameCount getGameCount(String input) {
		try {
			return makeGameCount(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getGameCount();
		}
	}

	private static GameCount makeGameCount(String input) {
		input = input.trim();
		GameCountValidator.checkAccuracyOfGameCount(input);
		return new GameCount(Integer.parseInt(input));
	}

	private static String takeUserInput() {
		return SCANNER.nextLine();
	}
}
