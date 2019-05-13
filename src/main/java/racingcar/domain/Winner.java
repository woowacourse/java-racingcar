package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
	private List<String> winnerNames;

	public Winner(List<Car> cars, Car maxPositionCar) {
		winnerNames = new ArrayList<>();

		for (int i = 0; i < cars.size(); ++i) {
			if (cars.get(i).compareTo(maxPositionCar) == 0) {
				winnerNames.add(cars.get(i).toString());
			}
		}
	}

	public List<String> getWinner() {
		return winnerNames;
	}
}
