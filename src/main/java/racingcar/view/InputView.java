package racingcar.view;

import java.util.List;
import java.util.Scanner;

import racingcar.domain.Car;
import racingcar.util.Converter;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

	public static List<Car> getCarNames() {
		System.out.println(CAR_NAMES_MESSAGE);
		return Converter.toCarList(scanner.next());
	}

	public static int getAttemptNumber() {
		System.out.println(ATTEMPT_NUMBER_MESSAGE);
		return Converter.toAttemptNumber(scanner.next());
	}
}