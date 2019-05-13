package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
	private List<String> winnerNames;

	public Winner(List<Car> cars, int maxPosition) {
		winnerNames = new ArrayList<>();

		for (int i = 0; i < cars.size(); ++i) {
			if (cars.get(i).matchPosition(maxPosition)) {
				winnerNames.add(cars.get(i).toString());
			}
		}
	}

	public List<String> getWinner() {
		return winnerNames;
	}
}
