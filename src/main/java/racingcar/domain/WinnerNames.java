package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerNames {
	private final List<String> winnerNames = new ArrayList<>();

	public void addWinnerByFastestCar(Car car, Car fastest) {
		if (fastest.compareTo(car) == 0) {
			winnerNames.add(car.getCarName());
		}
	}

	public List<String> getWinnerNames() {
		return this.winnerNames;
	}
}
