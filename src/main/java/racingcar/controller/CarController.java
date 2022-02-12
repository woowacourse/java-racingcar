package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import racingcar.model.CarDto;
import racingcar.model.Cars;
import racingcar.model.RandomNo;

public class CarController {
	private static final String CAR_NAME_DELIMITER = ",";
	private final Cars cars;
	private final RandomNo randomNo;

	public CarController() {
		this.cars = new Cars();
		this.randomNo = new RandomNo();
	}

	public String[] splitCarNames(String input) {
		return Stream.of(input.split(CAR_NAME_DELIMITER))
			.map(String::trim)
			.toArray(String[]::new);
	}

	protected void run() {
		int numberOfCars = cars.getSize();
		cars.move(createRandomNumbers(numberOfCars));
	}

	protected List<CarDto> getWinners() {
		return cars.getWinners();
	}

	protected List<CarDto> getCars() {
		return cars.getCars();
	}

	private List<Integer> createRandomNumbers(int size) {
		return IntStream.range(0, size)
			.mapToObj(i -> randomNo.getNumber())
			.collect(Collectors.toList());
	}

	protected void createCars(String carNames) {
		String[] splitCarNames = splitCarNames(carNames);
		cars.createCars(splitCarNames);
	}
}
