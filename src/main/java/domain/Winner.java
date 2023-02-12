package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
	private final List<Car> winningCar = new ArrayList<>();
	private final List<String> finalWinner = new ArrayList<>();

	public Winner(Cars cars) {
		List<Car> winners = new ArrayList<>(cars.getCars());
		int maxDistance = findMaxDistance(winners);
		findWinner(winners, maxDistance);
	}

	private int findMaxDistance(List<Car> winners) {
		int distance = 0;
		for (Car car : winners) {
			if (distance < car.getDistance()) {
				distance = car.getDistance();
			}
		}
		return distance;
	}

	private void findWinner(List<Car> candidate, int maxDistance) {
		for (int i = 0; i < candidate.size(); i++) {
			addWinner(candidate, maxDistance, i);
		}
	}

	private void addWinner(List<Car> candidate, int maxDistance, int index) {
		if (candidate.get(index).getDistance() == maxDistance) {
			winningCar.add(candidate.get(index));
		}
	}

	public List<String> getWinners() {
		for (Car car : winningCar) {
			finalWinner.add(car.getCarName());
		}
		return finalWinner;
	}
}
