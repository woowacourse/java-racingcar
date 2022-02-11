package racingcar.domain;

import java.util.List;
import java.util.ArrayList;

public class WinnerNames {
	private List<String> winnerNames = new ArrayList<>();

	public void addWinnerByFastestCar(Car car, Car fastest) {
		if (fastest.compareTo(car) == 0) {
			winnerNames.add(car.getCarName());
		}
	}

	public List<String> getWinnerNames() {
		return this.winnerNames;
	}
}
