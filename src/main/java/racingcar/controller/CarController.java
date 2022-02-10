package racingcar.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import racingcar.model.Car;
import racingcar.model.CarRepository;

public class CarController {
	private CarRepository carRepository = CarRepository.getInstance();

	public void createCars(String userInputCarNames) {
		carRepository.clear();
		String[] carNames = splitCarNames(userInputCarNames);
		validDuplicationCarNames(carNames);
		Arrays.stream(carNames)
			.forEach(carName -> carRepository.save(new Car(carName)));
	}

	private void validDuplicationCarNames(String[] carNames) {
		Set<String> temp = new HashSet<>(Arrays.asList(carNames));
		if (temp.size() != carNames.length) {
			throw new RuntimeException("중복된 자동차 이름이 입력됐습니다.");
		}
	}

	public String[] splitCarNames(String input) {
		return Stream.of(input.split(",")).map(String::trim).toArray(String[]::new);
	}

	public void run() {
		carRepository.move();
	}

	public List<Car> getWinners() {
		return carRepository.getWinners();
	}

	public List<Car> getCars() {
		return carRepository.getCars();
	}
}
