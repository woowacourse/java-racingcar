package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
	private final List<Car> winners = new ArrayList<>();

	public Winners(List<Car> winnerCars) {
		winners.addAll(winnerCars);
	}

	public List<String> getNames() {
		return winners.stream()
					  .map(Car::getName)
					  .collect(Collectors.toList());
	}
}
