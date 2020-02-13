package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;

public class Winner {

	public static List<Car> getWinners(List<Car> carList) {
		final List<Car> winners = new ArrayList<>();

		int max = getWinnerPosition(carList);
		for (Car car : carList) {
			if (isWinnerPosition(max, car)) {
				winners.add(car);
			}
		}
		return winners;
	}

	private static int getWinnerPosition(List<Car> carList) {
		int maxPosition = Integer.MIN_VALUE;
		int position;

		for (Car car : carList) {
			position = car.getPosition();
			if (position > maxPosition) {
				maxPosition = position;
			}
		}
		return maxPosition;
	}

	private static boolean isWinnerPosition(int maxPosition, Car car) {
		return maxPosition == car.getPosition();
	}
}
