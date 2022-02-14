package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.Car;
import racingcar.utlis.Convertor;
import racingcar.validator.NameValidator;

public class RacingCarService {

	List<Car> cars = new ArrayList<>();

	public void playRound() {
		cars.forEach(Car::decideMove);
	}

	public void saveCars(String inputCarNames) {
		List<String> carNames = Arrays.asList(Convertor.separateNamesByDelimiter(inputCarNames));
		NameValidator.checkNameList(carNames);
		save(carNames);
	}

	private void save(List<String> carNames) {
		for (String name : carNames) {
			cars.add(new Car(name, 0));
		}
	}

	public int findMaxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			if (car.isOverMaxPosition(maxPosition)) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}

	public List<String> findWinner() {
		int maxPosition = findMaxPosition();
		return cars.stream()
			.filter(car -> car.matchPosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toUnmodifiableList());
	}

	public List<Car> findAllCars() {
		return Collections.unmodifiableList(cars);
	}

	public void resetCars() {
		cars = new ArrayList<>();
	}
}