package racingcar.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import racingcar.model.Car;
import racingcar.model.CarDto;
import racingcar.model.CarRepository;
import racingcar.model.RandomNo;

public class CarController {
	private static final String CAR_NAMES_DUPLICATE_ERROR_MESSAGE = "중복된 자동차 이름이 입력됐습니다.";
	private static final String CAR_NAME_DELIMITER = ",";
	private final CarRepository carRepository = CarRepository.getInstance();
	private final RandomNo randomNo = new RandomNo();

	protected void createCars(String userInputCarNames) {
		carRepository.clear();
		String[] carNames = splitCarNames(userInputCarNames);
		validDuplicationCarNames(carNames);
		Arrays.stream(carNames)
			.forEach(carName -> carRepository.save(new Car(carName)));
	}

	public String[] splitCarNames(String input) {
		return Stream.of(input.split(CAR_NAME_DELIMITER))
			.map(String::trim)
			.toArray(String[]::new);
	}

	protected void run() {
		int numberOfCars = carRepository.getSize();
		carRepository.move(createRandomNumbers(numberOfCars));
	}

	protected List<CarDto> getWinners() {
		return carRepository.getWinners();
	}

	protected List<CarDto> getCars() {
		return carRepository.getCars();
	}

	private void validDuplicationCarNames(String[] carNames) {
		Set<String> temp = new HashSet<>(Arrays.asList(carNames));
		if (temp.size() != carNames.length) {
			throw new RuntimeException(CAR_NAMES_DUPLICATE_ERROR_MESSAGE);
		}
	}

	private List<Integer> createRandomNumbers(int size) {
		return IntStream.range(0, size)
			.mapToObj(i -> randomNo.getNumber())
			.collect(Collectors.toList());
	}
}
