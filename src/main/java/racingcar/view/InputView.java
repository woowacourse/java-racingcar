package racingcar.view;

import java.util.List;
import java.util.Scanner;

import racingcar.domain.Car;
import racingcar.util.Converter;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

	public List<Car> getCarNames() {
		System.out.println(CAR_NAMES_MESSAGE);
		return Converter.toCarList(scanner.next());
	}
}
