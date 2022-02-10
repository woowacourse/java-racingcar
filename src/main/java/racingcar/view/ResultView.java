package racingcar.view;

import java.util.List;

import racingcar.model.Car;

public class ResultView {
	public static void printGameResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			System.out.println("-".repeat(car.getPosition()));
		}
		System.out.println();
	}
}
