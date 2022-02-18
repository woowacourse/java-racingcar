package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import racingcar.service.CheckingService;
import racingcar.service.RandomNumberMovingCondition;

public class Cars {
	public static final String COMMA_DELIMITER = ",";
	private List<Car> cars;

	public Cars(String inputCarNames) {
		List<String> carNames = splitCarNames(inputCarNames);
		CheckingService.checkCarNamesBlank(inputCarNames);
		cars = toCar(carNames);
	}

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	private List<String> splitCarNames(String carNames) {
		return Arrays.asList(carNames.split(COMMA_DELIMITER));
	}

	private List<Car> toCar(List<String> carNames) {
		List<Car> cars = new ArrayList<Car>();
		try {
			carNames.stream()
				.forEach(carName -> cars.add(new Car(carName, new RandomNumberMovingCondition())));
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return cars;
	}

	public void moveCars() {
		cars.stream().forEach(Car::move);
	}

	public List<String> getPosition() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.toList());
	}

	public List<String> findWinnerCars() {
		Car maxPositionCar = findWinnerCar();
		List<String> winners = new ArrayList<String>();
		cars.stream()
			.filter(maxPositionCar::isSamePosition)
			.forEach(car -> car.appendName(winners));
		return winners;
	}

	public Car findWinnerCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public boolean equals(Object obj) {
		Cars cars = (Cars)obj;

		return this.cars.equals(cars.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.cars);
	}
}
