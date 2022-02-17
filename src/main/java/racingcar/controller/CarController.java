package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarDto;
import racingcar.model.CarRepository;
import racingcar.model.RandomNo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CarController {
	private static final String CAR_NAMES_DUPLICATE_ERROR_MESSAGE = "중복된 자동차 이름이 입력됐습니다.";
	private static final String CAR_NAME_DELIMITER = ",";
	private final CarRepository carRepository;

	public CarController() {
		carRepository = new CarRepository();
	}

	protected void createCars(String userInputCarNames) {
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
		return carRepository.getCarDtos();
	}

	private void validDuplicationCarNames(String[] carNames) {
		Set<String> duplicationSet = new HashSet<>(Arrays.asList(carNames));
		if (duplicationSet.size() != carNames.length) {
			throw new RuntimeException(CAR_NAMES_DUPLICATE_ERROR_MESSAGE);
		}
	}

	private List<Integer> createRandomNumbers(int size) {
		return IntStream.range(0, size)
			.mapToObj(i -> RandomNo.getNumber())
			.collect(Collectors.toList());
	}

	public List<CarDto> toCarDtos(List<String> names) {
		List<CarDto> carDtos = new ArrayList<>();
		for (String name: names) {
			carDtos.add(new CarDto(name));
		}
		return carDtos;
	}
}
