package racingcar.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import racingcar.model.Car;
import racingcar.model.CarRepository;

public class CarController {
	private static final String CAR_NAMES_DUPLICATE_ERROR_MESSAGE = "중복된 자동차 이름이 입력됐습니다.";
	private static final String CAR_NAME_DELIMITER = ",";
	private final CarRepository carRepository = CarRepository.getInstance();

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
			throw new RuntimeException(CAR_NAMES_DUPLICATE_ERROR_MESSAGE);
		}
	}

	public String[] splitCarNames(String input) {
		return Stream.of(input.split(CAR_NAME_DELIMITER)).map(String::trim).toArray(String[]::new);
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
