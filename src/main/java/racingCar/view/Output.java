package racingCar.view;

import java.util.List;

import racingCar.model.Car;

public class Output {

	static final String ERROR_MSG = "[ERROR]";
	static final String POSITION_SIGNATURE = "-";

	public static void printError(String e) {
		System.out.println(ERROR_MSG + e);
	}

	public static void printResult() {
		System.out.println("실행 결과");
	}

	public static void printRoundResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(
				car.getName() + " : " + new String(new char[car.getPosition()]).replace("\0", POSITION_SIGNATURE));
		}
		System.out.println();
	}
}
//"*".repeat(100);
// new String(new char[i]).replace("\0", "0");
