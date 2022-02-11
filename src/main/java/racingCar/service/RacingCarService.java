package racingCar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingCar.model.Car;
import racingCar.utlis.Convertor;
import racingCar.validator.NameValidator;

public class RacingCarService {

	List<Car> cars = new ArrayList<>();

	public void runRound() {
		for (Car car : cars) {
			car.decideMove();
		}
	}

	public void saveCars(String carsNames) throws Exception {
		List<String> carNameList = new ArrayList<>(Arrays.asList(Convertor.separateNamesByDelimiter(carsNames)));
		NameValidator.checkNameList(carNameList);
		save(carNameList);
	}

	public void save(List<String> carNameList) throws Exception {
		for (String name : carNameList) {
			cars.add(new Car(name));
		}
	}

	public int findMaxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			if (car.getPosition() >= maxPosition) {
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
			.collect(Collectors.toList());
	}

	public List<Car> findAllCars() {
		return cars;
	}
}