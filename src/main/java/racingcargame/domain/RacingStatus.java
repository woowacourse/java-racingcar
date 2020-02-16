package racingcargame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingStatus {
	private List<Car> racingStatus;

	RacingStatus(List<Car> racingStatus) {
		this.racingStatus = cloneCars(racingStatus);
	}

	private List<Car> cloneCars(List<Car> cars) {
		List<Car> tempCars = new ArrayList<>();
		cars.forEach(car -> tempCars.add(new Car(car)));
		return tempCars;
	}

	List<String> getWinners() {
		Collections.sort(racingStatus);
		int maxPosition = racingStatus.get(0).getCarPosition();

		return racingStatus.stream()
			.filter(car -> car.isMaxPosition(maxPosition))
			.map(Car::getCarName)
			.collect(Collectors.toList());
	}

	public List<Car> getRacingStatus() {
		return racingStatus;
	}
}
