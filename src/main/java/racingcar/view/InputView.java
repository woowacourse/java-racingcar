package racingcar.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import racingcar.domain.Car;
import racingcar.domain.Count;
import racingcar.domain.RandomMovingPolicy;

public class InputView {
	private static final String CAR_DELIMITER = ",";
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

	private static final Scanner scanner = new Scanner(System.in);

	public static List<Car> getCars() {
		return Arrays.stream(InputView.getCarNames())
			.map(carName -> new Car(carName, new RandomMovingPolicy()))
			.collect(toList());
	}

	private static String[] getCarNames() {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);
		String input = scanner.nextLine();

		return input.split(CAR_DELIMITER);
	}

	public static Count getCount() {
		System.out.println(INPUT_COUNT_MESSAGE);
		return new Count(scanner.nextLine());
	}
}
