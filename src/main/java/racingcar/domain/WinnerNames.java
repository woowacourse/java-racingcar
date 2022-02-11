package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerNames {
	private List<String> winnerNames = new ArrayList<>();

	private static final int SAME_POSITION = 0;

	public void addWinnerByFastestCar(Car car, Car fastest) {
		if (fastest.compareTo(car) == SAME_POSITION) {
			winnerNames.add(car.getCarName());
		}
	}

	public List<String> getWinnerNames() {
		return this.winnerNames;
	}
}
