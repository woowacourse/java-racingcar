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

	public void saveCars(String carsNames) throws Exception {
		List<String> carNameList = Arrays.asList(Convertor.separateNamesByDelimiter(carsNames));
		NameValidator.checkNameList(carNameList);
		save(carNameList);
	}

	private void save(List<String> carNameList) throws Exception {
		for (String name : carNameList) {
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
			.filter(car -> car.isWinner(maxPosition))
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